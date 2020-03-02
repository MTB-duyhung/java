/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0056;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Lab6P0056 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Worker> lw = new ArrayList<>();
        ArrayList<History> lh = new ArrayList<>();
        WorkerList w=new WorkerList();
        HistoryList h=new HistoryList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    w.addWorker(lw);
                    break;
                case 2:
                    h.changeSalary(lw,lh,1);
                    break;
                case 3:
                    h.changeSalary(lw,lh,2);
                    break;
                case 4:
                    h.printListHistory(lh);
                    break;
                case 5:
                    return;
            }
        }
    }
}
