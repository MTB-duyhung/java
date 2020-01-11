/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String name;
    private String studentId;
    private Date birthDate;
    private String address;
    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    void get() {
        Scanner in = new Scanner(System.in);
        System.out.print("name: ");
        name = in.nextLine();
        System.out.print("studntID: ");
        studentId = in.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy/m/d");
        System.out.print("birthday: ");
        try {
            birthDate = df.parse(in.nextLine());
        } catch (ParseException ex) {
        }
        System.out.print("address: ");
        address = in.nextLine();
        System.out.print("major: ");
        major = in.nextLine();
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy/m/d");
        return "Student{" + "name=" + name + ", studentId=" + studentId + ", birthDate=" + df.format(birthDate) + ", address=" + address + ", major=" + major + '}';
    }

    public static void main(String[] args) {
        Student std = new Student();
        std.get();
        System.out.println(std);
    }

}
