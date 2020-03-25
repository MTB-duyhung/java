package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

public class BookDB {
    
    //Get Book by BookID
    public Book getBook(String aBookID){
        Book b=null;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Books where BookID='"+aBookID+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               b=new Book(bookID,title,author,category,keyword);
            }            
            conn.close();
            System.out.println("Get Book successfully!");
        } catch (Exception ex) {
            System.out.println("Get Book failure!");            
        }  
        return b;
    }  
    
    //Get all of Books -> ArrayList
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> allBooks=new ArrayList<>();       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from Books");
            while(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               Book b=new Book(bookID,title,author,category,keyword);
               allBooks.add(b);
            }            
            conn.close();
            System.out.println("Get all of Books successfully!");
        } catch (Exception ex) {
            System.out.println("Get all of Books failure!");            
        }  
        return allBooks;
    }  
    
    //Add a new Book
    public int addNewBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "INSERT INTO Books(BookID, Title, Author, Category, Keyword) VALUES(?,?,?,?,?)";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1,aBookID);
            stmt.setString(2,aTitle);
            stmt.setString(3,aAuthor);
            stmt.setString(4,aCategory);
            stmt.setString(5,aKeyword);            
            rc=stmt.executeUpdate();          
            conn.close();
            System.out.println("Add Book successfully!");            
        } catch (Exception ex) {
            System.out.println("Add Book failure!");            
        }  
        return rc;
    }
    
    //Update a Book
    public int updateBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "Update Books set title=?,author=?,category=?,keyword=? where BookID=?";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1,aTitle);
            stmt.setString(2,aAuthor);
            stmt.setString(3,aCategory);
            stmt.setString(4,aKeyword); 
            stmt.setString(5,aBookID);
            rc=stmt.executeUpdate();          
            conn.close();
            System.out.println("Update Book successfully!");            
        } catch (Exception ex) {
            System.out.println("Update Book failure!");            
        }  
        return rc;
    }
    
    //Delete a Book
    public int deleteBook(String aBookID){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "Delete from Books where BookID='"+aBookID+"'";
            Statement stmt= conn.createStatement();
            rc=stmt.executeUpdate(sql);                   
            conn.close();
            System.out.println("Delete Book successfully!");            
        } catch (Exception ex) {
            System.out.println("Delete Book failure!");            
        }  
        return rc;
    }
    
    //Search Book by Title -> ArrayList
    public ArrayList<Book> searchByTitle(String aTitle){
        ArrayList<Book> tBook=new ArrayList<>();;       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Books where Title='"+aTitle+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               Book b=new Book(bookID,title,author,category,keyword);
               tBook.add(b);
            }            
            conn.close();
            System.out.println("Get Books by Tittle  successfully!");
        } catch (Exception ex) {
            System.out.println("Get Books by Title failure!");            
        }  
        return tBook;
    }
    
    //Search Book by Author -> ArrayList
    public ArrayList<Book> searchByAuthor(String aAuthor){
        ArrayList<Book> aBook=new ArrayList<>();;       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Books where Author='"+aAuthor+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               Book b=new Book(bookID,title,author,category,keyword);
               aBook.add(b);
            }            
            conn.close();
            System.out.println("Get Books by Author successfully!");
        } catch (Exception ex) {
            System.out.println("Get Books by Author failure!");            
        }  
        return aBook;
    }
    
    //Search Book by Category -> ArrayList
    public ArrayList<Book> searchByCategory(String aCategory){
        ArrayList<Book> cBook=new ArrayList<>();;       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Books where Category='"+aCategory+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               Book b=new Book(bookID,title,author,category,keyword);
               cBook.add(b);
            }            
            conn.close();
            System.out.println("Get Books by Category  successfully!");
        } catch (Exception ex) {
            System.out.println("Get Books by Category failure!");            
        }  
        return cBook;
    }
    
    //Search Book by Keyword -> ArrayList
    public ArrayList<Book> searchByKeyword(String aKeyword){
        ArrayList<Book> kBook=new ArrayList<>();;       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Books where Keyword='"+aKeyword+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
               String bookID=rs.getString(1);
               String title=rs.getString(2);
               String author=rs.getString(3);
               String category=rs.getString(4);
               String keyword=rs.getString(5);
               Book b=new Book(bookID,title,author,category,keyword);
               kBook.add(b);
            }            
            conn.close();
            System.out.println("Get Books by Keyword successfully!");
        } catch (Exception ex) {
            System.out.println("Get Books by Keyword failure!");            
        }  
        return kBook;
    }    
}
