/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16p007xx;

/**
 *
 * @author Admin
 */
public class Manager {

    public static void menu() {
        System.out.println("1. Admin Login");
        System.out.println("2. Librarian Login");
        System.out.println("3. Exits");
        System.out.print("Enter your choice: ");
    }

    public static void menuAdmin() {
        System.out.println("1. Add Librarian");
        System.out.println("2. View Librarian");
        System.out.println("3. Delete Librarian");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
    }

    public static void menuLibrarian() {
        System.out.println("1. Add Books");
        System.out.println("2. View Books");
        System.out.println("3. Issue Book");
        System.out.println("4. View Issued Books");
        System.out.println("5. Return Book");
        System.out.println("6. Logout");
        System.out.print("Enter your choice: ");
    }
}
