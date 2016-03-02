package com.sameperson.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {

    private BufferedReader reader;
    private PrintWriter writer;


    public void run() {
        Socket sock = setUpClientNetworking();
        Scanner consoleReader = new Scanner(System.in);

        System.out.println("Type your message: ");

        while(true) {
            String message = consoleReader.nextLine();
            writer.println(message);
            writer.flush();
        }

    }

    private Socket setUpClientNetworking() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Network esteblished!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return socket;
    }

}
