/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16p007xx;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class IssueBooks {
    private int id;
    private String bookCallno;
    private int studentId;
    private String studentName, studentContact;
    private Date issuedDate;

    public IssueBooks() {
    }

    public IssueBooks(int id, String bookCallno, int studentId, String studentName, String studentContact, Date issuedDate) {
        this.id = id;
        this.bookCallno = bookCallno;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentContact = studentContact;
        this.issuedDate = issuedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCallno() {
        return bookCallno;
    }

    public void setBookCallno(String bookCallno) {
        this.bookCallno = bookCallno;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Override
    public String toString() {
        return "IssueBooks{" + "id=" + id + ", bookCallno=" + bookCallno + ", studentId=" + studentId + ", studentName=" + studentName + ", studentContact=" + studentContact + ", issuedDate=" + issuedDate + '}';
    }
    
}
