/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Student {
    int ID;
    String Name;
    boolean Gender;
    Date DOB;

    public Student() {
    }

    public Student(int ID, String Name, boolean Gender, Date DOB) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.DOB = DOB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
}
