/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryNhan;

/**
 *
 * @author Admin
 */
public class Book {
    private String bookID, title, author, category, keyword;

    public Book() {
    }

    public Book(String bookID, String title, String author, String category, String keyword) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.keyword = keyword;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return bookID + "\t" + title + "\t" + author + "\t" + category + "\t" + keyword + "\n";
    }

    
}
