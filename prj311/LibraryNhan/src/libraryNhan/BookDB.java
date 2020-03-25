/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDB {
    //--------------------------------------------------------------------

    public Book getBook(String bid) throws SQLException {
        Book b = null;
        try {
            Connection con;
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select title, author, category,keyword from Books where bookID='" + bid + "'");
            if (rs.next()) {
                String title = rs.getString(1);
                String author = rs.getString(2);
                String category = rs.getString(3);
                String keyword = rs.getString(4);
                String bookID = bid;
                b = new Book(bookID, title, author, category, keyword);
            }
            con.close();
            return b;
        } catch (Exception ex) {
            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //--------------------------------------------------------------------   

    public ArrayList<Book> printAll() {
        ArrayList<Book> arr = new ArrayList<>();
        try {
            Connection con;
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Books ");
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String keyword = rs.getString(4);
                String category = rs.getString(5);
                Book b = new Book(bookID, title, author, category, keyword);
                arr.add(b);
            }
            con.close();
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//-------------------------------------------------------------------- 

    public ArrayList<Book> searchByCategory(String cat) {
        ArrayList<Book> arr = new ArrayList<>();
        try {
            Connection con;
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select bookID, title, author,keyword from Books where category='" + cat + "'");
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String keyword = rs.getString(4);
                String category = cat;
                Book b = new Book(bookID, title, author, category, keyword);
                arr.add(b);
            }
            con.close();
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //-------------------------------------------------------------------- 

    public ArrayList<Book> searchByKeyword(String key) {
        ArrayList<Book> arr = new ArrayList<>();
        try {
            Connection con;
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select bookID, title, author, category from Books where keyword='" + key + "'");
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = key;
                Book b = new Book(bookID, title, author, category, keyword);
                arr.add(b);
            }
            con.close();
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //--------------------------------------------------------------------   

    public int addNewBook(String bookID, String title, String author, String category, String keyword) {
        int rc = 0;
        try {
            Connection con;
            con = ConnectDB.getConnection();
            String sql = "Insert into Books (bookID, title, author, category, keyword) values (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, bookID);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, category);
            stmt.setString(5, keyword);
            rc = stmt.executeUpdate();
            con.close();
            System.out.println("Add successfully");
        } catch (Exception ex) {
            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rc;
    }
    //--------------------------------------------------------------------   

    public Vector<Vector> searchByTitle(String title) {
        return null;
    }
    //--------------------------------------------------------------------   
}
