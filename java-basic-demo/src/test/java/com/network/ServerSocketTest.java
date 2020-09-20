package com.network;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket Example
 */
public class ServerSocketTest {

    @Test
    public void testSocketServer() throws InterruptedException {
        new Thread(new Server()).start();
        Thread.sleep(5000);
        new Thread(new Client()).start();
        while (true) {

        }

    }

    class Server implements Runnable {

        @Override
        public void run() {

            try {
                ServerSocket serverSocket = new ServerSocket(6888);
                while (true) {
                    Socket socket = serverSocket.accept();
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    printWriter.println("Hello Client!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    class Client implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 6888);
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();
                System.out.println("client receive:" + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
