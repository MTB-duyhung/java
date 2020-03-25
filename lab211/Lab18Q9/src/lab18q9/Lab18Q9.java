/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q9;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Lab18Q9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        OrderBuilder builder = new OrderBuilder();
        OrderedItems orderedItems = builder.preparePizza();
        System.out.println("=====Bill=====");
        orderedItems.showItems();
        System.out.println("\n");
        System.out.println("Total Cost : " + orderedItems.getCost());
    }

}
