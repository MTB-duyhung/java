/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q7;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class AbstractFactoryPatternExample {

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        FactoryCreator fc = new FactoryCreator();
        AbstractFactory af;
        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName = in.nextLine();
        af = fc.getFactory("bank");
        Bank bank = af.getBank(bankName);
        System.out.print("Enter the type of loan you want to take, like home loan or bussiness loan or education loan: ");
        String loanName = in.nextLine();
        af = fc.getFactory("loan");
        Loan loan = af.getLoan(loanName);
        System.out.print("Enter the interest rate for " + bank.getBankName() + ": ");
        double interestRate = in.nextDouble();
        loan.getInterestRate(interestRate);
        System.out.print("Enter the loan amount you want to take: ");
        double loadAmount = in.nextDouble();
        System.out.print("Enter the number of years to pay your entire loan anount: ");
        int years=in.nextInt();
        System.out.println("You are taking the loan from "+bank.getBankName());
        loan.calculateLoanPayment(loadAmount, years);
    }
}
