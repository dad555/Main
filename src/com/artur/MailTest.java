package com.artur;

import java.io.*;
import java.net.Socket;

public class MailTest {

    static PrintStream ps = null;          // посылка сообщений
    static DataInputStream dis = null;     // получение сообщений

    public static void send(String str) throws IOException
    {
        ps.println(str);      // посылка строки на SMTP
        ps.flush();           // очистка буфера
        System.out.println("Java sent: " + str);
    }

    public static void receive() throws IOException
    {
        String readstr = dis.readLine();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
    }

    public static void main (String args[]) throws IOException, InterruptedException {
        String HELO = "HELO gazprom.ru";
        String MAIL_FROM = "MAIL FROM: user@gazprom.ru ";
        String RCPT_TO = "RCPT TO: pikselnsk@yandex.ru ";
        String DATA = "DATA";    // начало сообщения
        String FROM = "from: user@gazprom.ru";
        String SUBJECT = "subject: tema ";
        String BODY = "Hello my friend! Java sent this!";
        String END = ".";

        Socket smtp = null;     // сокет SMTP

        try {  // заметка: 25 - это стандартный номер порта SMTP
            smtp = new Socket("mx.yandex.ru", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            System.out.println("Error connection: " + e);
        }
        try {  // скажем SMTP helo
            receive();          // получение ответа SMTP
            send(HELO);
            receive();          // получение ответа SMTP
            send(MAIL_FROM);    // посылка на SMTP
            receive();          // получение ответа SMTP
            send(RCPT_TO);      // посылка адресату SMTP
            receive();
            send(DATA);         // начинается посылка на SMTP
            receive();          // получение ответа SMTP
            send(FROM);
            send(SUBJECT);
            send(BODY);         // посылка тела сообщения
            send(END);
            receive();
            smtp.close();
        }
        catch (IOException e)
        {
            System.out.println("Error sending: " + e);
        }
        System.out.println("Mail sent!");
    }
}