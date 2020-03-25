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
public class BankFactory extends AbstractFactory {

    @Override
    public Bank getBank(String bank) {
        if (bank == null) {
            return null;
        }
        if (bank.equalsIgnoreCase("HDFC")) {
            return new HDFC();
        }
        if (bank.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        }
        if (bank.equalsIgnoreCase("SBI")) {
            return new SBI();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;

    }

}
