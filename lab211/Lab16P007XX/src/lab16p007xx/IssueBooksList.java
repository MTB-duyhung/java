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
public class IssueBooksList {

    ArrayList<IssueBooks> lis = new ArrayList<>();
    LibrarianList lib = new LibrarianList();
    BooksList bl = new BooksList(lib);

    public IssueBooksList(BooksList bl) {
        this.bl = bl;
    }

    public void issueBook(int id) {
        if (bl.getLb().isEmpty()) {
            System.err.println("No book");
        }
        System.out.print("Book CallNo: ");
        String isCallno = Validation.checkInputString();
        if (Validation.checkCallnoExist(bl.getLb(), isCallno) == -1) {
            System.err.println("Not found book. Please re-input.");
            return;
        }
        Books b = getBooksByCallno(isCallno);
        if (b.getQuantity() <= 0) {
            System.err.println("Quantity=0. Can't issued this book.");
            return;
        } else {
            System.out.print("Student Id: ");
            int isStudentId = Validation.checkInputInt();
            System.out.print("Student Name: ");
            String isStudentName = Validation.checkInputString();
            System.out.print("Student Contact: ");
            String isStudentContact = Validation.checkInputString();
            Date issuedDate = new Date();
            lis.add(new IssueBooks(id, isCallno, isStudentId, isStudentName, isStudentContact, issuedDate));

            b.setIssued(b.getIssued() + 1);
            b.setQuantity(b.getQuantity() - 1);
            System.err.println("Issue book successful.");
        }
    }

    public void viewIssueBooks() {
        System.out.printf("%-10s%-15s%-15s%-15s%-20s%-15s\n", "id", "callno", "StudentId", "StudentName", "Contact", "issuedDate");
        for (IssueBooks b : lis) {
            System.out.printf("%-10d%-15s%-15s%-15s%-15s%-15s\n", b.getId(), b.getBookCallno(), b.getStudentId(), b.getStudentName(), b.getStudentContact(), b.getIssuedDate());
        }
    }

    public void returnBook() {
        System.out.print("Issue Book ID: ");
        int delIssueId = Validation.checkInputInt();
        IssueBooks delIssue = getIssueBooksById(delIssueId);
        Books b = getBooksByCallno(delIssue.getBookCallno());
        b.setIssued(b.getIssued() - 1);
        b.setQuantity(b.getQuantity() + 1);
        lis.remove(delIssue);
        System.out.println("Return book successful.");
    }

    public Books getBooksByCallno(String callno) {
        for (Books b : bl.getLb()) {
            if (b.getCallno().equalsIgnoreCase(callno)) {
                return b;
            }
        }
        return null;
    }

    public IssueBooks getIssueBooksById(int id) {
        for (IssueBooks ib : lis) {
            if (ib.getId() == (id)) {
                return ib;
            }
        }
        return null;
    }
}
