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
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountantList {

    ArrayList<Accountant> la = new ArrayList<>();

    public ArrayList<Accountant> getLa() {
        return la;
    }

    public boolean loginAdmin() {
        System.out.print("Username(yet):");
        String username = Validation.checkInputString();
        System.out.print("Password(123456):");
        String password = Validation.checkInputString();
        if (username.equals("yet") && password.equals("123456")) {
            System.err.println("Login Admin successful.");
            return true;
        } else {
            System.err.println("Login Admin unsuccessful.");
            return false;
        }
    }

    public void addAccountant(int id) {
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Password: ");
        String password = Validation.checkInputString();
        System.out.print("Email: ");
        String email = Validation.checkInputString();
        System.out.print("Contact No: ");
        String contact = Validation.checkInputString();
        la.add(new Accountant(id, name, password, email, contact));
        System.err.println("Add successful.");
    }

    public void viewAccountant() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s\n", "id", "name", "password", "email", "contact");
        for (Accountant ac : getLa()) {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s\n", ac.getAccID(), ac.getAccName(), ac.getAccPass(), ac.getAccEmail(), ac.getAccContactNo());
        }
    }

    public void writeObjectFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(la);
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
            la=(ArrayList)ois.readObject();
            System.err.println("Read file "+filename+" success");
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
