package com.artur.templates.chat.client;

import com.artur.templates.chat.Connection;
import com.artur.templates.chat.ConsoleHelper;
import com.artur.templates.chat.Message;
import com.artur.templates.chat.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client extends Thread {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        String serverAddress;
        ConsoleHelper.writeMessage("Enter server address to start");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter your Name for access to chat room:");
        return ConsoleHelper.readString();
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("A connection fails to send your message");
            clientConnected = false;
        }
    }

    public void run() {
        {
            SocketThread socketThread = getSocketThread(); // создаем новый сокетный поток с помощью метода getSocketThread()
            socketThread.setDaemon(true); // помечаем созданный поток как daemon, чтобы при выходе из программы вспом. потом прерваля автоматисески
            socketThread.start(); // запускаем вспом. поток
            /** тек. поток ожидает, пока не получит нотификацию из другово потока.
             * Используем wait() и синхронизацию на уровне объекта
             */
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка потока...");
                System.exit(1);
            }
            if (clientConnected) { // После того, как поток дождался нотификации, проверяем значение clientConnected
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’"); // если clientConnected = true;
                while (clientConnected) { // в бесконечном цикле считываем сообщения по клиент подключен
                    String message = ConsoleHelper.readString();
                    if (message.equalsIgnoreCase("exit")) {
                        break; // выходим, если ввели exit
                    } else {
                        if (shouldSendTextFromConsole()) {
                            sendTextMessage(message); // после каждого считывания, если метод shouldSendTextFromConsole() = true, отправляем считанный текст с помощью метода sendTextMessage().
                        }
                    }
                }
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента."); // если clientConnected = false;
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    // класс отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера
    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message); // выводим текст message в консоль
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("User has enter the chat " + userName);
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Ladies and Gentleman " + userName + " has left the building");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected; // Устанавливаем значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
                Client.this.notify(); // Оповещаем (пробуждать ожидающий) основной поток класса Client.
            }
        }

        // метод будет представлять клиента серверу
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;

            while (!clientConnected) { // в цикле получаем сообщения, используя соединение connection
                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                }
                /**Если тип полученного сообщения NAME_REQUEST (сервер запросил имя), запросить ввод имени
                 * пользователя с помощью метода getUserName(), создать новое сообщение с типом MessageType.USER_NAME
                 * и введенным именем, отправить сообщение серверу.
                 */
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));

                    /**
                     * Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя),
                     * значит сервер принял имя клиента, нужно об этом сообщить главному потоку, используя
                     * метод notifyConnectionStatusChanged() передав в него true
                     */
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                    } else throw new IOException("Unexpected MessageType");
                }
            }
        }

        // метод реализует главный цикл обработки сообщений сервера
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;

            while (true) { // в цикле получаем сообщения, используя соединение connection

                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                else if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                else break;
            }
            throw new IOException("Unexpected MessageType");
        }

        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}

