package edu.fud.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoang My
 */
public class Book {

    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String category;
    private String language;
    private String preview;
    private String picture;
    private String content;

    public Book() {
    }

    public Book(String bookID, String title, String author, String publisher, int year, String category, String language, String preview, String picture, String content) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.category = category;
        this.language = language;
        this.preview = preview;
        this.picture = picture;
        this.content = content;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   
}
