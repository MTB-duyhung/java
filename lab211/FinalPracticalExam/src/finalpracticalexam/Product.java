/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

/**
 *
 * @author Admin
 */
public class Product implements Comparable<Product> {

    private String productName, productID;
    private double productPrice;

    public Product() {
    }

    public Product(String productID, String productName, double productPrice) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productID=" + productID + ", productPrice=" + productPrice + '}';
    }

    @Override
    public int compareTo(Product p1) {
        if (p1.getProductPrice() > this.productPrice) {
            return -1;
        } else {
            return 1;
        }
    }

}
