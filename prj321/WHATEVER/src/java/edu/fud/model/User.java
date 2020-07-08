/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.model;

import edu.fud.DAO.userDAO;

/**
 *
 * @author Hoang My
 */
public class User {

    private String userID;
    private String name;
    private String userName;
    private String password;
    private String email;
    private int userRight;

    public User() {
    }

    public User(String userID, String name, String userName, String password, String email, int userRight) {
        this.userID = userID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRight = userRight;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserRight() {
        return userRight;
    }

    public void setUserRight(int userRight) {
        this.userRight = userRight;
    }

    public boolean changePass(String oldP, String newP) {
        if (password.equals(oldP)) {
            password = newP;
            return userDAO.updateUser(this);
        }
        return false;
    }

}
