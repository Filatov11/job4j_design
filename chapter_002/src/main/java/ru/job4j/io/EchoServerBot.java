package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerBot {
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public static void main(String[] args) throws IOException {
        EchoServerBot echoServerBot = new EchoServerBot();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("GET")) {
                            System.out.println(httpMessage(str));
                            echoServerBot.setMessage(httpMessage(str));
                            if (echoServerBot.message.equals("Exit")) {
                                server.close();
                                break;
                            }


                        }

                        if (str.contains("msg=Exit")) {
                            server.close();
                            break;
                        }

                    }
                    if ((echoServerBot.getMessage().equals("Hello"))) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello, dear friend.".getBytes());
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What???".getBytes());
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String httpMessage(String string) {
        String[] sentences = string.split(" ");
        String value = "";

        int posA = sentences[1].indexOf('=');

        value = sentences[1].substring(posA + 1);

        return value;
    }
}
