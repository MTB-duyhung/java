/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feereport;

/**
 *
 * @author Admin
 */
public class Manager {

    public static void menu() {
        System.out.println("1. Admin Login");
        System.out.println("2. Accountant Login");
        System.out.println("3. Exits");
        System.out.print("Enter your choice: ");
    }

    public static void menuAdmin() {
        System.out.println("1. Add Accountant");
        System.out.println("2. View Accountant");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }

    public static void menuAccountant() {
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Due Fee");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }

    public static void menuEdit() {
        System.out.println("1. Edit information");
        System.out.println("2. Edit Fee");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

}
