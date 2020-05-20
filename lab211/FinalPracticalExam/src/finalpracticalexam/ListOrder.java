/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ListOrder implements IListOrder {

    private String customerId;
    List<Order> a = new ArrayList<>();
    Order o = new Order();
    Scanner in = new Scanner(System.in);

    @Override
    public boolean checkCustomerID(String id) {
        for (int i = 0; i < o.getA().size(); i++) {
            if (o.getA().get(i).getCustomerID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkCustomerId(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkOrderId(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getOrderId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String generateCustomerID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkCustomerID(id)) {
                return id;
            }
        } while (true);
    }

    @Override
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    @Override
    public void addOrder(Store p) {
        customerId = generateCustomerID();
        System.out.print("Enter customer name: ");
        String customerName = Validation.checkInputString();
        System.out.print("Enter customer address: ");
        String address = Validation.checkInputString();
        p.print();
        char checkYN;
        o.addProduct(p, customerId, customerName, address, getDate());
        do {
            System.out.print("Add more product(y/n): ");
            checkYN = Validation.checkInputString().charAt(0);
            if (checkYN == 'y') {
                o.addProduct(p, customerId, customerName, address, getDate());
            } else if (checkYN == 'n') {
                break;
            } else {
                System.out.println("Re-input");
            }
        } while (true);
        
    }

    @Override
    public void printByCustomerId(Store p, String id) {
        o.printByCustomerId(id);
    }

    @Override
    public void printByOrderID(Store p, String id) {
        o.printByOrderId(id);
    }

    @Override
    public void print() {
        o.print();
    }

}
