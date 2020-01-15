/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2decimaltosomething;

/**
 *
 * @author Admin
 */
public class Manager {


    public static int menu() {
        System.out.println("1. Convert From Binary");
        System.out.println("2. Convert From Decimal");
        System.out.println("3. Convert From Hexa");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validation.checkInputIntLimit(1, 2);
        return result;
    }

}