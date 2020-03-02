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
public class WorkerList {

    public void addWorker(ArrayList<Worker> lw) {
        System.out.print("Enter code: ");
        String id = Validation.checkInputString();
        if (Validation.checkIdExist(lw, id) != false) {
            System.err.println("Id has exist worker. Please re-input.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter age: ");
        int age = Validation.checkInputIntLimit(0, 100);
        System.out.print("Enter salary: ");
        int salary = Validation.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = Validation.checkInputString();
        lw.add(new Worker(id, name, age, salary, workLocation));
        System.err.println("Add success.");
    }
}
