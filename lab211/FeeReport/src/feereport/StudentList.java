/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feereport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentList {

    ArrayList<Student> ls = new ArrayList<>();
    AccountantList la = new AccountantList();

    public ArrayList<Student> getLs() {
        return ls;
    }

    public StudentList(AccountantList la) {
        this.la = la;
    }

    public boolean loginAcc() {
        System.out.print("Username:");
        String username = Validation.checkInputString();
        System.out.print("Password:");
        String password = Validation.checkInputString();
        for (Accountant l : la.getLa()) {
            if (username.equals(l.getAccName()) && password.equals(l.getAccPass())) {
                System.err.println("Login Accountant successful.");
                return true;
            }
        }
        System.err.println("Login Accountant fail.");
        return false;
    }

    public void addStudent(int id) {
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Email: ");
        String email = Validation.checkInputString();
        System.out.print("Course: ");
        String course = Validation.checkInputString();
        System.out.print("Fee: ");
        int fee = Validation.checkInputInt();
        System.out.print("Paid:");
        int paid = Validation.checkInputInt();
        int due = fee - paid;
        System.out.println("Due: " + due);
        System.out.print("Address: ");
        String address = Validation.checkInputString();
        System.out.print("City: ");
        String city = Validation.checkInputString();
        System.out.print("State: ");
        String state = Validation.checkInputString();
        System.out.print("Country: ");
        String country = Validation.checkInputString();
        System.out.print("Contact No: ");
        String contactNo = Validation.checkInputString();
        ls.add(new Student(id, name, email, course, fee, paid, due, address, city, state, country, contactNo));
        System.err.println("Add successful.");
    }

    public void viewStudent() {
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "id", "name", "email", "course", "fee", "paid", "due", "address", "city", "state", "country", "Contact No");
        for (Student s : ls) {
            System.out.printf("%-10s%-15s%-15s%-15s%-15d%-15d%-15d%-15s%-15s%-15s%-15s%-15s\n", s.getId(), s.getName(), s.getEmail(), s.getCourse(),
                    s.getFee(), s.getPaid(), s.getDue(), s.getAddress(), s.getCity(), s.getState(), s.getCountry(), s.getContactNo());
        }
    }

    public void editStudent() {
        viewStudent();
        System.out.println("Enter Student ID: ");
        int id = Validation.checkInputInt();
        Student st = getStudentByID(id);
        if (st != null) {
            Manager.menuEdit();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    editInfo(st);
                    break;
                case 2:
                    editFee(st);
                    break;
                case 3:
                    break;
            }
        }

    }

    public void editInfo(Student s) {
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Email: ");
        String email = Validation.checkInputString();
        System.out.print("Course: ");
        String course = Validation.checkInputString();
        System.out.print("Address: ");
        String address = Validation.checkInputString();
        System.out.print("City: ");
        String city = Validation.checkInputString();
        System.out.print("State: ");
        String state = Validation.checkInputString();
        System.out.print("Country: ");
        String country = Validation.checkInputString();
        System.out.print("Contact No: ");
        String contactNo = Validation.checkInputString();
        ls.get(s.id).setName(name);
        ls.get(s.id).setEmail(email);
        ls.get(s.id).setCourse(course);
        ls.get(s.id).setAddress(address);
        ls.get(s.id).setCity(city);
        ls.get(s.id).setState(state);
        ls.get(s.id).setCountry(country);
        ls.get(s.id).setContactNo(contactNo);
        System.err.println("Edit Success");
    }

    public void editFee(Student s) {
        System.out.print("Fee: ");
        int fee = Validation.checkInputInt();
        System.out.print("Paid:");
        int paid = Validation.checkInputInt();
        int due = fee - paid;
        System.out.println("Due: " + due);
        ls.get(s.id).setFee(fee);
        ls.get(s.id).setPaid(paid);
        ls.get(s.id).setDue(due);
        System.err.println("Edit Success");
    }

    public Student getStudentByID(int id) {
        for (Student s : ls) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void dueFee() {
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "id", "name", "email", "course", "fee", "paid", "due", "address", "city", "state", "country", "Contact No");
        for (Student s : ls) {
            if (s.getDue() != 0) {
                System.out.printf("%-10s%-15s%-15s%-15s%-15d%-15d%-15d%-15s%-15s%-15s%-15s%-15s\n", s.getId(), s.getName(), s.getEmail(), s.getCourse(),
                        s.getFee(), s.getPaid(), s.getDue(), s.getAddress(), s.getCity(), s.getState(), s.getCountry(), s.getContactNo());
            }
        }
    }
    public void writeObjectFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ls);
            oos.close();
            fos.close();
            System.err.println("Write file "+filename+" success");
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void readObjectFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ls=(ArrayList)ois.readObject();
            System.err.println("Read file "+filename+" success");
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
