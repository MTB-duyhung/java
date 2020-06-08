/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CustomerAccount {
    String accountType;
    double balanceAmount;

    public CustomerAccount() {
    }

    public CustomerAccount(String accountType, double balanceAmount) {
        this.accountType = accountType;
        this.balanceAmount = balanceAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    
}
