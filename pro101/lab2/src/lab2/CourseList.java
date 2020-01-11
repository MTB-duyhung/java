/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class CourseList {

    private ArrayList<Course> ls = new ArrayList<Course>();

    public CourseList() {
        ls.add(new Course("1", "Java", 3));
        ls.add(new Course("2", "C", 2));
    }

    public void add() {
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.println("Enter name course: ");
            String name = Validation.checkInputString();
            if (Validation.checkIdExist(ls, id) != -1) {
                System.err.println("Id has exist student. Please re-input.");
                return;

            }
            System.out.print("Enter number of credit: ");
            int numberOfCredit = Validation.checkInputIntLimit(0, 5);
            ls.add(new Course(id, name, numberOfCredit));
            System.out.println("Add course success.");
            System.out.print("Do you want to continue : y/n: ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public void searchAndDisplay() {
        if (ls.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        ArrayList<Course> listCourseFindById = new ArrayList<>();
        System.out.print("Enter id to search: ");
        String id = Validation.checkInputString();
        for (Course course : ls) {
            if (course.getId().contains(id)) {
                listCourseFindById.add(course);
            }
        }
        if (listCourseFindById.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listCourseFindById);
            System.out.printf("%-15s%-15s%-15s\n", "Id", "Name", "Number Of Credit");
            for (Course course : listCourseFindById) {
                course.print();
            }
        }
    }

    public void sortAscending() {
        if (ls.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        Collections.sort(ls);
        for (Course l : ls) {
            l.print();
        }
    }

    public void update() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id to update: ");
        String id = Validation.checkInputString();
        int index = Validation.checkIdExist(ls, id);
        if (index == -1) {
            System.err.println("Not found course.");
            return;
        } else {
            System.out.print("Enter name course: ");
            String name = Validation.checkInputString();
            System.out.print("Enter number of credit: ");
            int numberOfCredit = Validation.checkInputIntLimit(0, 5);
            ls.get(index).setName(name);
            ls.get(index).setNumberOfCredit(numberOfCredit);
            System.err.println("Update success.");
            return;
        }
    }

    public void report() {
        if (ls.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        System.out.printf("%-15s%-15s%-15s\n", "Id", "Name", "Number Of Credit");
        for (Course l : ls) {
            l.print();
        }
    }

    public ArrayList<Course> getLs() {
        return ls;
    }

    public void setLs(ArrayList<Course> ls) {
        this.ls = ls;
    }
}
