/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FinalPracticalExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IStore p = new Store();
        IListOrder o = new ListOrder();
        Order od = new Order();
        Scanner in = new Scanner(System.in);
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 9);
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = in.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(in.nextLine());
                    p.addProduct(new Product(p.generateProductID(), name, price));
                    break;
                case 2:
                    System.out.print("Enter product id: ");
                    String id = in.nextLine();
                    if (!p.checkProductId(id)) {
                        System.out.print("Enter new price: ");
                        double newPrice = Double.parseDouble(in.nextLine());
                        p.updatePrice(id, newPrice);
                    } else {
                        System.out.println("Not found id!!!");
                    }
                    break;
                case 3:
                    p.print();
                    break;
                case 4:
                    o.addOrder((Store) p);
                    o.print();
                    break;
                case 5:
                    System.out.print("Enter order Id: ");
                    String orderId = in.nextLine();
                    if (o.checkOrderId(orderId)) {
                        o.printByOrderID((Store) p, orderId);
                    } else {
                        System.out.println("Not found order id!!!");
                    }
                    break;
                case 6:
                    p.sortByPrice();
                    p.print();
                    break;
                case 7:
                    System.out.print("Enter customer Id: ");
                    String customerId = in.nextLine();
                    if (o.checkCustomerId(customerId)) {
                        o.printByCustomerId((Store) p, customerId);
                    } else {
                        System.out.println("Not found customer id!!!");
                    }
                    break;
                case 8:
                    o.print();
                    break;
                case 9:
                    return;
            }
        }
    }

}
