/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Store implements IStore {

    List<Product> a = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Store() {
    }

    @Override
    public void addProduct(Product p) {
//        System.out.print("Enter product ID: ");
//        String proID = Validation.checkInputString();
//        System.out.print("Enter product name: ");
//        String proName = Validation.checkInputString();
//        System.out.print("Enter product price: ");
//        double proPrice = Validation.checkInputDouble();
        a.add(p);
        System.out.println("Add a product success!!");
    }

    @Override
    public boolean checkProductId(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getProductID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String generateProductID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkProductId(id)) {
                return id;
            }
        } while (true);
    }

    @Override
    public void updatePrice(String productId, double newPrice) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getProductID().equals(productId)) {
                a.get(i).setProductPrice(newPrice);
                System.out.println("Update price success!!");
                return;
            }
        }
        System.out.println("Not found id!!");
    }

    @Override
    public void sortByPrice() {
        Collections.sort(a);
    }

    @Override
    public void print() {
        System.out.printf("%-15s%-15s%-15s\n", "productID", "productName", "productPrice");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-15s%-15s%-15.2f\n", a.get(i).getProductID(),a.get(i).getProductName(),a.get(i).getProductPrice());
        }
    }

    @Override
    public String getProductName(String productID) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getProductID().equals(productID)) {
                return a.get(i).getProductName();
            }
        }
        return null;
    }

    @Override
    public double getProductPrice(String productID) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getProductID().equals(productID)) {
                return a.get(i).getProductPrice();
            }
        }
        return 0;
    }

}
