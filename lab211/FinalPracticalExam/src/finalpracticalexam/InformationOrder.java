/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpracticalexam;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InformationOrder {

    private String orderID, date, customerID, customerName, customerAddress, productid, productName;
    private int quantity;
    private double productPrice;

    public InformationOrder() {
    }

    public InformationOrder(String orderID, String date, String customerID, String customerName, String customerAddress, String productid, String productName, int quantity, double productPrice) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.productid = productid;
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
