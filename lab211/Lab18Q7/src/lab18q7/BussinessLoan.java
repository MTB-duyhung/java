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
public class BussinessLoan extends Loan{

    @Override
    void getInterestRate(double rate) {
        this.rate = rate;
    }

    public BussinessLoan() {
    }
    
}
