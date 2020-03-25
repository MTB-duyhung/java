/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q9;

/**
 *
 * @author Admin
 */
public class Manager {

    public static void menuPizza() {
        System.out.println("============================");
        System.out.println("1. Veg-Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.println("3. Exit");
        System.out.println("============================");
        System.out.print("Enter the choice of Pizza: ");
    }

    public static void menuTypePizza() {
        System.out.println("------------------------------");
        System.out.println("1.Cheeze Pizza");
        System.out.println("2.Onion Pizza");
        System.out.println("3.Masala Pizza");
        System.out.println("4.Exit");
        System.out.println("------------------------------");
        System.out.print("Enter the pizza type: ");
    }

    public static void menuSizePizza() {
        System.out.println("------------------------------------");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Extra-Large");
        System.out.println("------------------------------------");
        System.out.print("Enter the pizza size: ");
    }

    public static void menuColdDrink() {
        System.out.println("============================");
        System.out.println("1. Pepsi");
        System.out.println("2. Coke");
        System.out.println("3. Exit");
        System.out.println("============================");
        System.out.print("Enter the choice of cold drink: ");
    }

    public static void menuSizeColdDrink() {
        System.out.println("------------------------");
        System.out.println("1. Small Pepsi ");
        System.out.println("2. Medium Pepsi ");
        System.out.println("3. Large Pepsi ");
        System.out.println("------------------------");
        System.out.print("Enter the cold drink size ");
    }
}
