/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Admin
 */
public class SimpleClient {

    public static void main(String[] args) throws IOException {
        final String serverHost = "localhost";
        Socket socketOfClient = null;
        BufferedWriter os = null;
        BufferedReader is = null;
        socketOfClient = new Socket(serverHost, 9999);
        os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
        is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        try {
            os.write("HELLO");
            os.newLine();
            os.flush();
            os.write("I am TomCat");
            os.newLine();
            os.flush();
            os.write("QUIT");
            os.newLine();
            os.flush();
            String responseLine;
            while ((responseLine=is.readLine())!=null) {
                System.out.println("Sever: "+responseLine);
            }
            os.close();
            is.close();
            socketOfClient.close();
        } catch (UnknownHostException e) {
            System.out.println("Try to connect unkown host");
        }
    }
}
