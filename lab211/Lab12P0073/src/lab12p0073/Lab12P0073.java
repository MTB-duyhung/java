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
public class Lab12P0073 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExpensesList ls = new ExpensesList();
        ArrayList<Expenses> le = new ArrayList<>();
        int id = 1;
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ls.addExpense(le, id);
                    id++;
                    break;
                case 2:
                    ls.displayExpense(le);
                    break;
                case 3:
                    ls.deleteExpense(le);
                    break;
                case 4:
                    return;
            }
        }
    }

}
