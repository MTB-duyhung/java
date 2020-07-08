/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.model;

import java.util.Date;

/**
 *
 * @author Hoang My
 */
public class Library {
    private String libraryID;
    private String bookID;
    private Date time;

    public Library() {
    }

    public Library(String libraryID, String bookID, Date time) {
        this.libraryID = libraryID;
        this.bookID = bookID;
        this.time = time;
    }

    public String getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
