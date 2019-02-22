package com.artur.templates.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// основной класс сервера
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>(); // потокобезопасный Map

    // отправка сообщения всем соединениям
    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error sending message");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Input server port: ");
        // запросили порт сервера и создали серверный сокет
        // try с ресурсами закроет серверный сокет в случае возникновения ислючения, а
        // catch выведет сообщение об этом
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started...");
            while (true) { // в цикле слушаем и принимаем входящие сокетные соединения
                // создаем и запускаем (метод start() новый поток Handler,
                // передавая в конструктор сокет (метод accept())
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Something wrong, Server socket closed.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }

            String userName = null;

            try (Connection connection = new Connection(socket)) { // создаем коннект используя поле socket

                userName = serverHandshake(connection); // вызываем метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName)); // рассылаем всем участникам чата информацию об имени присоединившегося участника
                notifyUsers(connection, userName); // сообщаем новому участнику о существующих участниках.
                serverMainLoop(connection, userName); // запускаем главный цикл обработки сообщений сервером.
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            ConsoleHelper.writeMessage("Введите ваше имя");
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST)); // запрос имени
                Message answer = connection.receive(); // получили ответ

                if (answer.getType() == MessageType.USER_NAME) { // проверка, что получено сообщение с именем пользователя
                    if (!answer.getData().isEmpty()) { // проверка, что имя не пустое
                        if (!connectionMap.containsKey(answer.getData())) { // проверка, что такого пользователя нет в коллекции
                            connectionMap.put(answer.getData(), connection); // добавление нового пользователя в коллекцию
                            connection.send(new Message(MessageType.NAME_ACCEPTED)); // отправка клиенту команду информирующую, что его имя принято
                            return answer.getData(); // возврат имени
                        }
                    }
                }
            }
        }

        // отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        // главный цикл обработки сообщений сервером
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive(); // приняли сообщение клиента
                if (message != null && message.getType() == MessageType.TEXT) { // проверили, что сообщение имеент тип TEXT и не пустое
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData())); // с помощью метода sendBroadcastMessage() отпрвляем сформированное сообщение всем клиентам
                } else {
                    ConsoleHelper.writeMessage("Server Main Loop Error!"); // если принятое сообщение не является текстом, выводим сообщение об ошибке
                }
            }
        }
    }
}
