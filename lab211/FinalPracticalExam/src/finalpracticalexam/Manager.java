/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

/**
 *
 * @author Admin
 */
public class Manager {
    public static void menu(){
        System.out.println("1. Add a new product to the Store");
        System.out.println("2. Update price for a particular product");
        System.out.println("3. A list of all available products in the Store");
        System.out.println("4. Create a new Order");
        System.out.println("5. Print information of an Order by Order ID");
        System.out.println("6. Sort all products by product price as ascending");
        System.out.println("7. Print information of all Orders by a specific customer ID");
        System.out.println("8. Export information of a specific Order ID to text file");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
}
