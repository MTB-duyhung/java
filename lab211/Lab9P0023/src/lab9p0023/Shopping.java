/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9p0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Shopping {

    Hashtable<String, ArrayList<Order>> ht = new Hashtable<String, ArrayList<Order>>();
    ArrayList<Fruit> lf;
    ArrayList<Order> lo = new ArrayList<>();
    FruitList ls = new FruitList();
    private Object hashTable;

    public Shopping(FruitList ls) {
        this.ls = ls;
    }

    public Shopping(ArrayList<Fruit> lf) {
        this.lf = lf;
    }

    public Shopping(Hashtable<String, ArrayList<Order>> ht, ArrayList<Fruit> lf) {
        this.ht = ht;
        this.lf = lf;
    }

    Fruit getFruitByItem(int item) {
        int countItem = 1;
        for (Fruit fruit : ls.getLf()) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void createShopping() {

        if (ls.getLf().isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        while (true) {
            ls.displayListFruit();
            System.out.print("Your selected: ");
            int item = Validation.checkInputInt();
            Fruit fruit = getFruitByItem(item);
            System.out.print("Quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(fruit.getFruitId(), quantity);
            } else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(), fruit.getPrice(),
                        quantity));
            }
            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayListOrder();
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        ht.put(name, lo);
        System.err.println("Add successfull");
    }

    public void displayListFruit() {
        int countItem = 1;
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Item", "Fruit ID", "Fruit name", "Origin", "Price");
        for (Fruit fruit : ls.getLf()) {
            System.out.printf("%-10s%-20s%-20s%-15d\n", countItem, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            countItem++;
        }
    }

    public void displayListOrder() {
        double total = 0;
        int count = 0;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            count++;
            double amount;
            amount = order.getPrice() * order.getQuantity();
            System.out.printf("%-10s%-20s%-20s%-15s\n", count + ". " + order.getFruitName(), order.getQuantity(), "$" + order.getPrice(), "$" + amount);
            total += amount;
        }
        System.out.println("Total= " + total);
    }

    public void updateOrder(String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    public void viewOrder() {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            lo = ht.get(name);
            displayListOrder();
        }
    }
}
