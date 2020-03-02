/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9p0023;

/**
 *
 * @author Admin
 */
public class Order {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;

    public Order() {
    }

    public Order(String fruitId, String fruitName, double price, int quantity) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "fruitId=" + fruitId + ", fruitName=" + fruitName + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
}
