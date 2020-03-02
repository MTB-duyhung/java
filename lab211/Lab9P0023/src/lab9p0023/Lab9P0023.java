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
public class Lab9P0023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Fruit> lf = new ArrayList<>();
        ArrayList<Order> lo = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht;
        FruitList ls = new FruitList();
        Shopping sh = new Shopping(ls);
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ls.createFruit();
                    break;
                case 2:
                    sh.viewOrder();
                    break;
                case 3:
                    sh.createShopping();
                    break;
                case 4:
                    return;
            }
        }
    }
}
