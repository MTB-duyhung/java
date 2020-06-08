
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account type: ");
        String type = sc.next();
        System.out.print("Enter account balance($): ");
        double balance = sc.nextDouble();
        CustomerAccount acc1 = new CustomerAccount(type, balance);
        System.out.print("Enter account type: ");
        type = sc.next();
        System.out.print("Enter account balance($): ");
        balance = sc.nextDouble();
        System.out.print("Total money to transfer: ");
        double amount = sc.nextDouble();
        CustomerAccount acc2 = new CustomerAccount(type, balance);
        TransferManager t1 = new TransferManager(amount,acc1, acc2);
        Thread tt1 = new Thread(t1);
        tt1.start();
        tt1.join();
        System.out.println("Number of transfer instance: " + t1.getTransferCount());
        System.out.println("Account balance after transfer: ");
        System.out.println(acc1.getAccountType() + ": " + acc1.getBalanceAmount());
        System.out.println(acc2.getAccountType() + ": " + acc2.getBalanceAmount());
    }

}
