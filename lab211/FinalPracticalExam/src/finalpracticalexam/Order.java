/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Order {

    private String orderId, customerId;
    List<InformationOrder> a = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Order() {
    }

    public Order(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<InformationOrder> getA() {
        return a;
    }

    public void setLs(List<InformationOrder> a) {
        this.a = a;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public boolean checkOrderID(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getOrderID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public String generateOrderID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkOrderID(id)) {
                return id;
            }
        } while (true);
    }

    public boolean checkCustomerID(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void addProduct(Store p, String customerID, String customerName, String address, String date) {
        System.out.println("Enter product id: ");
        String id = Validation.checkInputString();
        orderId=generateOrderID();
        customerId=customerID;
        if (!p.checkProductId(id)) {
            System.out.println("Enter quantity: ");
            int quantity = Integer.parseInt(in.nextLine());
            a.add(new InformationOrder(orderId, date, customerId, customerName, address, id, p.getProductName(id), quantity, p.getProductPrice(id)));
            System.out.println("Add product success!!");
        } else {
            System.out.println("Not found id!!");
        }
    }

    public void print() {
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "OrderID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Product Price");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", customerId, orderId, a.get(i).getCustomerName(), a.get(i).getProductid(),
                    a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getCustomerAddress(), a.get(i).getQuantity(), a.get(i).getProductPrice());
            total += a.get(i).getQuantity() * a.get(i).getProductPrice();
        }
        System.out.println("Total: " + total);
    }

    public void printByCustomerId(String id) {
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "OrderID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Product Price");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerID().equalsIgnoreCase(id)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", customerId, orderId, a.get(i).getCustomerName(), a.get(i).getProductid(),
                        a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getCustomerAddress(), a.get(i).getQuantity(), a.get(i).getProductPrice());
                total += a.get(i).getQuantity() * a.get(i).getProductPrice();
            }
        }
        System.out.println("Total: " + total);
    }

    public void printByOrderId(String id) {
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "OrderID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Product Price");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getOrderID().equalsIgnoreCase(id)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", customerId, orderId, a.get(i).getCustomerName(), a.get(i).getProductid(),
                        a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getCustomerAddress(), a.get(i).getQuantity(), a.get(i).getProductPrice());
                total += a.get(i).getQuantity() * a.get(i).getProductPrice();
            }
        }
        System.out.println("Total: " + total);
    }
}
