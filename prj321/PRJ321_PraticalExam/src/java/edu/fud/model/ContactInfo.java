/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class ContactInfo implements  Serializable{
    private int id;
    private String firstname, lastName, phone;
    private int groupID;
    private String groupName;

    public ContactInfo() {
    }

    public ContactInfo(int id, String firstname, String lastName, int groupID, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.phone = phone;
        this.groupID = groupID;
    }

    public ContactInfo(int id, String firstname, String lastName, String groupName, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.groupName = groupName;
        this.phone = phone;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    

}
