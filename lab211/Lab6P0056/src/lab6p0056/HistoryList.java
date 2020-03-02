/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0056;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class HistoryList {

    public void changeSalary(ArrayList<Worker> lw,ArrayList<History> lh,int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        System.out.print("Enter code: ");
        String id = Validation.checkInputString();
        Worker worker = getWorkerByCode(lw,id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            if (status == 1) {
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = Validation.checkInputSalary();
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorlLocation()));
            } else {
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = Validation.checkInputSalary();
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorlLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success.");
        }
    }

    public void printListHistory(ArrayList<History> lh) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "status", "date", "id", "name", "age", "salary", "worlLocation");
        for (History history : lh) {
            printHistory(history);
        }
    }

    public Worker getWorkerByCode(ArrayList<Worker> lw,String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void printHistory(History history) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15d%-15d%-15s\n",history.status,history.date,history.id, history.name, history.age, history.salary, history.worlLocation);
    }
}
