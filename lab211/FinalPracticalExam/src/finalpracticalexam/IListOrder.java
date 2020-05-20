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
public interface IListOrder {

    public boolean checkCustomerID(String id);

    public boolean checkCustomerId(String id);

    public boolean checkOrderId(String id);

    public String generateCustomerID();

    public String getDate();

    public void addOrder(Store p);

    public void printByCustomerId(Store p, String id);

    public void printByOrderID(Store p, String id);

    public void print();
}
