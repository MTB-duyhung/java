/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q6;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab18Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GetPlanFactory planFactory = new GetPlanFactory();
        System.out.print("Enter the name of plan for which the bill will be generated: ");
        String planName = Validation.checkInputString();
        Plan p = planFactory.getPlan(planName);
        p.getRate();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units = Validation.checkInputInt();
        System.out.println("Bill amount for commercialplan of " + units + " units is: ");
        p.calculateBill(units);
    }
    
}
