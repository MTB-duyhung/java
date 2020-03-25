/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q9;

/**
 *
 * @author Admin
 */
public class SmallCoke extends Coke {

    @Override
    public String name() {
        return "300 ml Coke";
    }

    @Override
    public String size() {
        return "Small Size";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
