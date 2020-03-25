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
public class MediumCoke extends Coke {

    @Override
    public String name() {
        return "500 ml Coke";
    }

    @Override
    public String size() {
        return "Medium Size";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
