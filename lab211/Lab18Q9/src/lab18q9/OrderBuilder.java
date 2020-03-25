/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class OrderBuilder {

    public OrderedItems preparePizza() throws IOException {

        OrderedItems itemsOrder = new OrderedItems();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Manager.menuPizza();
        int pizzaandcolddrinkchoice = Integer.parseInt(br.readLine());
        switch (pizzaandcolddrinkchoice) {
            case 1:
                System.out.println("You ordered Veg Pizza");
                Manager.menuTypePizza();
                int vegpizzachoice = Integer.parseInt(br.readLine());
                switch (vegpizzachoice) {
                    case 1:
                        System.out.println("You ordered Cheeze Pizza");
                        Manager.menuSizePizza();
                        int cheezepizzasize = Integer.parseInt(br.readLine());
                        switch (cheezepizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallCheezePizza());
                                break;
                            case 2:
                                itemsOrder.addItems(new MediumCheezePizza());
                                break;
                            case 3:
                                itemsOrder.addItems(new LargeCheezePizza());
                                break;
                            case 4:
                                itemsOrder.addItems(new ExtraLargeCheezePizza());
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("You ordered Onion Pizza");
                        Manager.menuSizePizza();
                        int onionpizzasize = Integer.parseInt(br.readLine());
                        switch (onionpizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallOnionPizza());
                                break;

                            case 2:
                                itemsOrder.addItems(new MediumOnionPizza());
                                break;

                            case 3:
                                itemsOrder.addItems(new LargeOnionPizza());
                                break;

                            case 4:
                                itemsOrder.addItems(new ExtraLargeOnionPizza());
                                break;

                        }
                        break;
                    case 3:
                        System.out.println("You ordered Masala Pizza");
                        Manager.menuSizePizza();
                        int masalapizzasize = Integer.parseInt(br.readLine());
                        switch (masalapizzasize) {
                            case 1:
                                itemsOrder.addItems(new SmallMasalaPizza());
                                break;

                            case 2:
                                itemsOrder.addItems(new MediumMasalaPizza());
                                break;

                            case 3:
                                itemsOrder.addItems(new LargeMasalaPizza());
                                break;

                            case 4:
                                itemsOrder.addItems(new ExtraLargeMasalaPizza());
                                break;

                        }
                        break;
                }
                break;// Veg- pizza choice completed.  
            case 2:
                System.out.println("You ordered Non-Veg Pizza");
                Manager.menuSizePizza();
                int nonvegpizzasize = Integer.parseInt(br.readLine());
                switch (nonvegpizzasize) {
                    case 1:
                        itemsOrder.addItems(new SmallNonVegPizza());
                        break;
                    case 2:
                        itemsOrder.addItems(new MediumNonVegPizza());
                        break;
                    case 3:
                        itemsOrder.addItems(new LargeNonVegPizza());
                        break;
                    case 4:
                        itemsOrder.addItems(new ExtraLargeNonVegPizza());
                        break;
                }
                break;
            default:
                break;
        }
        Manager.menuColdDrink();
        int coldDrink = Integer.parseInt(br.readLine());
        switch (coldDrink) {
            case 1:
                System.out.println("You ordered Pepsi ");
                Manager.menuSizeColdDrink();
                int pepsisize = Integer.parseInt(br.readLine());
                switch (pepsisize) {
                    case 1:
                        itemsOrder.addItems(new SmallPepsi());
                        break;

                    case 2:
                        itemsOrder.addItems(new MediumPepsi());
                        break;

                    case 3:
                        itemsOrder.addItems(new LargePepsi());
                        break;
                }
                break;
            case 2:
                System.out.println("You ordered Coke");
                Manager.menuSizeColdDrink();
                int cokesize = Integer.parseInt(br.readLine());
                switch (cokesize) {
                    case 1:
                        itemsOrder.addItems(new SmallCoke());
                        break;

                    case 2:
                        itemsOrder.addItems(new MediumCoke());
                        break;

                    case 3:
                        itemsOrder.addItems(new LargeCoke());
                        break;
                }
                break;
            default:
                break;
        }
        return itemsOrder;
    }
}
