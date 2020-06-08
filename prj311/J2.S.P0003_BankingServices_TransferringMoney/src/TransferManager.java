/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class TransferManager implements Runnable {

    private static int transferCount = 0;
    private double amount;
    private CustomerAccount account1;
    private CustomerAccount account2;

    public TransferManager() {
    }

    public TransferManager(double amount, CustomerAccount account1, CustomerAccount account2) {
        this.amount = amount;
        this.account1 = account1;
        this.account2 = account2;
    }

    public static int getTransferCount() {
        return transferCount;
    }

    public static void setTransferCount(int transferCount) {
        TransferManager.transferCount = transferCount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerAccount getAccount1() {
        return account1;
    }

    public void setAccount1(CustomerAccount account1) {
        this.account1 = account1;
    }

    public CustomerAccount getAccount2() {
        return account2;
    }

    public void setAccount2(CustomerAccount account2) {
        this.account2 = account2;
    }

    public void transfer(CustomerAccount acc1, CustomerAccount acc2, double amount) {
        transferCount++;
        acc1.setBalanceAmount(acc1.getBalanceAmount() - amount);
        acc2.setBalanceAmount(acc2.getBalanceAmount() + amount);
    }

    @Override
    public void run() {
        while (true) {
            if (account1.getBalanceAmount()> account2.getBalanceAmount()) {
                transfer(account1, account2, amount);
                System.out.println("Transfering " + amount + "$ from account " + account1.getAccountType() + " to account " + account2.getAccountType());
            } else if (account1.getBalanceAmount()< account2.getBalanceAmount()) {
                transfer(account2, account1, amount);
                System.out.println("Transfering " + amount + "$ from account " + account2.getAccountType() + " to account " + account1.getAccountType());
            } else {
                return;
            }
        }
    }
}
