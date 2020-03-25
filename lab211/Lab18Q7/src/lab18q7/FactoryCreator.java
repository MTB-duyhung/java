/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q7;

/**
 *
 * @author Admin
 */
public class FactoryCreator {
    public AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        }
        //if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        //}
    }
}
