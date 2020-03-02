/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12p0073;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ExpensesList {

    private static void addExpense(ArrayList<Expenses> le, int id) {
        System.out.print("Enter Date: ");
        //Students write here appropriate statements to complete this function       
        System.out.print("Enter Content: ");
        String content = Validation.checkInputString();
        le.add(new //Students write here appropriate statements to complete this function       
             
    
    }

    private static void displayExpense(ArrayList<Expenses> le) {
        if (le.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId() //Students write here appropriate statements to complete this function      
            //Students write here appropriate statements to complete this function      
            total += le.get(i).get //Students write here appropriate statements to complete this function      
        }

        System.out.printf("Total: %-20.0f\n", total);
    }

    private static int checkIdExist(ArrayList<Expenses> le, int id) {
        for (int i = 0; i < le.size(); i++) {
//Students write here appropriate statements to complete this function      
            return i;
        }
    }

return -1; 
} 

private static void deleteExpense(ArrayList<Expenses> le) { 
System.out.print("Enter id: "); 
int id = checkInputInt(); 
int checkIdExist =  //Students write here appropriate statements to complete this function      
if (checkIdExist != -1) { 
le.remove(checkIdExist); 
System.out.println("Delete an expense successful"); 
for (int i = id - 1; i < le.size(); i++) { 
le.get(i).setId(le.get(i).getId() - 1); 
} 
} else { 
System.err.println("Delete an expense fail"); 
} 
}
