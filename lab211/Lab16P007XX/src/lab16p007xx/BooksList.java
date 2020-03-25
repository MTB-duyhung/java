/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16p007xx;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BooksList {

    ArrayList<Books> lb = new ArrayList<>();
    LibrarianList lib = new LibrarianList();

    public ArrayList<Books> getLb() {
        return lb;
    }

    public BooksList(LibrarianList lib) {
        this.lib = lib;
    }

    public boolean loginLib() {
        System.out.print("Username:");
        String username = Validation.checkInputString();
        System.out.print("Password:");
        String password = Validation.checkInputString();
        for (Librarian l : lib.getLl()) {
            if (username.equals(l.getName()) && password.equals(l.getPassword())) {
                System.err.println("Login Lib successful.");
                return true;
            }
        }
        System.err.println("Login Lib unsuccessful.");
        return false;
    }

    public void addBooks(int id) {
        System.out.print("Callno: ");
        String callno = Validation.checkInputString();
        if (Validation.checkCallnoExist(lb, callno) != -1) {
            System.err.println("Callno has exist Books. Please re-input.");
            return;
        }
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Author: ");
        String author = Validation.checkInputString();
        System.out.print("Publisher: ");
        String publisher = Validation.checkInputString();
        System.out.print("Quantity: ");
        int quantity = Validation.checkInputInt();
        Date addedDate = new Date();
        lb.add(new Books(id, callno, name, author, publisher, quantity, 0, addedDate));
        System.err.println("Add successful.");
    }

    public void viewBooks() {
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "id", "callno", "name", "author", "publisher", "quantity", "issued", "added-date");
        for (Books b : lb) {
            System.out.printf("%-10d%-15s%-15s%-15s%-15s%-15d%-15d%-15s\n", b.getId(), b.getCallno(), b.getName(), b.getAuthor(), b.getPublisher(), b.getQuantity(), b.getIssued(), b.getAddedDate());
        }
    }

}
