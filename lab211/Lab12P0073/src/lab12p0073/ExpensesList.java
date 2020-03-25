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

    public void addExpense(ArrayList<Expenses> le, int id) {
        if (Validation.checkIdExist(le, id) != -1) {
            System.err.println("Id has exist expenses. Please re-input.");
            return;
        }
        System.out.print("Enter Date(dd-mm-yyyy): ");
        String date = Validation.checkInputDate();
        System.out.print("Enter amount: ");
        double amount = Validation.checkInputDouble();
        System.out.print("Enter Content: ");
        String content = Validation.checkInputString();
        le.add(new Expenses(id, date, amount, content));
        System.out.println("Add student success.");
    }

    public void displayExpense(ArrayList<Expenses> le) {
        if (le.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(), le.get(i).getAmount(), le.get(i).getContent());
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    public void deleteExpense(ArrayList<Expenses> le) {
        System.out.print("Enter id: ");
        int id = Validation.checkInputInt();
        if (Validation.checkIdExist(le, id) != -1) {
            le.remove(Validation.checkIdExist(le, id));
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < le.size(); i++) {
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }
}
