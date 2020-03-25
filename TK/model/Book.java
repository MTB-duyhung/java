package Model;

public class Book {    
    private String bookID, title, author, category, keyword;

    //Constructor method
    public Book() {
    }

    public Book(String bookID, String title, String author, String category, String keyword) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.keyword = keyword;
    }   

    //Get method
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }

    //Set method
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    //toString method
    @Override
    public String toString() {
        return "Book{" + "bookID=" + bookID + ", title=" + title + ", author=" + author + ", category=" + category + ", keyword=" + keyword + '}';
    }   
}
