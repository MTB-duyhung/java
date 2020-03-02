/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9p0023;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class FruitList {

    ArrayList<Fruit> lf = new ArrayList<>();

    public void createFruit() {
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Fruit exist!");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter fruit price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter fruit quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter fruit origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public void displayListFruit() {
        int count = 0;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            count++;
            System.out.printf("%-10s%-20s%-20s%-15s\n", count, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }
    }

    public Fruit getFruitById(String idDelete) {
        for (Fruit fruit : lf) {
            if (fruit.getFruitId().equalsIgnoreCase(idDelete)) {
                return fruit;
            }
        }
        return null;
    }

    public void remove() {
        System.out.print("Enter id: ");
        String idDelete = Validation.checkInputString();
        Fruit fruitDelete = getFruitById(idDelete);
        if (idDelete == null) {
            System.err.println("Not found fruit.");
            return;
        } else {
            lf.remove(idDelete);
        }
        System.err.println("Delete successful.");
    }

    public ArrayList<Fruit> getLf() {
        return lf;
    }

    public void setLf(ArrayList<Fruit> lf) {
        this.lf = lf;
    }

}
