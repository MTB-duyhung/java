/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication122;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class JavaApplication122 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lang;
        ResourceBundle bundle;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1. English");
            System.out.println("2. Vietnamese");
            System.out.println("3. Exit");
            System.out.print("Please choose your language: ");
            lang = in.nextInt();
            switch (lang) {
                case 1:
                    bundle = ResourceBundle.getBundle("javaapplication122.MessageBundle", Locale.US);
                    System.out.println("Message in " + Locale.US + ": " + bundle.getString("greeting"));
                    break;
                case 2:
                    Locale.setDefault(new Locale("vi","VN"));
                    bundle = ResourceBundle.getBundle("javaapplication122.MessageBundle");
                    System.out.println("Message in " + Locale.getDefault() + ": " + bundle.getString("greeting"));
                    break;
            }
        } while (lang != 3);

    }
    
}
