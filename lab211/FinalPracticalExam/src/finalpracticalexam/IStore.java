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
public interface IStore {

    public void addProduct(Product p);

    public boolean checkProductId(String id);

    public String generateProductID();

    public void updatePrice(String productId, double newPrice);

    public void sortByPrice();

    public void print();

    public String getProductName(String productID);

    public double getProductPrice(String productID);
}
