/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.model;

/**
 *
 * @author Admin
 */
public class GroupInfo {
    private int ID;
    private String Groupname, description;

    public GroupInfo() {
    }

    public GroupInfo(int ID, String Groupname, String description) {
        this.ID = ID;
        this.Groupname = Groupname;
        this.description = description;
    }

    public GroupInfo(String Groupname, String description) {
        this.Groupname = Groupname;
        this.description = description;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroupname() {
        return Groupname;
    }

    public void setGroupname(String Groupname) {
        this.Groupname = Groupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
