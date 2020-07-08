/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.DAO;

import edu.fud.model.Book;
import static edu.fud.model.databaseInfo.dbURL;
import static edu.fud.model.databaseInfo.driverName;
import static edu.fud.model.databaseInfo.passDB;
import static edu.fud.model.databaseInfo.userDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Hoang My
 */
public class bookDAO {

    public static void addNewBook(Book b) {
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Book(BookID, Title, Author,Publisher,Year,Category,Language,Preview,Picture,Content)"
                            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getPublisher());
            stmt.setInt(5, b.getYear());
            stmt.setString(6, b.getCategory());
            stmt.setString(7, b.getLanguage());
            stmt.setString(8, b.getPreview());
            stmt.setString(9, b.getPicture());
            stmt.setString(10, b.getContent());
            int rc = stmt.executeUpdate();
            con.close();
            if (rc != 1) {
                throw new RuntimeException("Add new book failed !");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean deleteBook(String bid) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("Delete FROM Book where BookID = ?");
            stmt.setString(1, bid);
            int rowCount = stmt.executeUpdate();
            con.close();
            return rowCount == 1;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateBook(Book b) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {

        }
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE Book SET BookID = ?, Title = ?, Author = ?,Publisher = ?,Year = ?,Category = ?,Language = ?,Preview = ?,Picture = ?,Content = ?");
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getPublisher());
            stmt.setInt(5, b.getYear());
            stmt.setString(6, b.getCategory());
            stmt.setString(7, b.getLanguage());
            stmt.setString(8, b.getPreview());
            stmt.setString(9, b.getPicture());
            stmt.setString(10, b.getContent());
            int rc = stmt.executeUpdate();
            con.close();
            if (rc != 1) {
                throw new RuntimeException("Book update failed");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static Book getBook(String bid) {
        try {
            Book book = null;
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Book WHERE BookID=?");
            stmt.setString(1, bid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new Book(bid, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }
            con.close();
            return book;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Vector<Vector> searchByCategory(String cat) {
        try {
            Vector<Vector> list = new Vector<>();
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Book WHERE Category=?");
            stmt.setString(1, cat);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vector vc = new Vector();
                vc.addElement(rs.getString(1));
                vc.addElement(rs.getString(2));
                vc.addElement(rs.getString(3));
                vc.addElement(rs.getString(4));
                vc.addElement(rs.getInt(5));
                vc.addElement(rs.getString(6));
                vc.addElement(rs.getString(7));
                vc.addElement(rs.getString(8));
                vc.addElement(rs.getString(9));
                vc.addElement(rs.getString(10));
                list.add(vc);
            }
            con.close();
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --------------------------------------------------------------------
    public static Vector<Vector> searchBook(String title) {
        try {
            Vector<Vector> list = new Vector<>();
            int i = 0;
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Book WHERE Title like'%?%'"+" or Author like'%?%'");
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vector element = new Vector();
                element.addElement(rs.getString(1));
                element.addElement(rs.getString(2));
                element.addElement(rs.getString(3));
                element.addElement(rs.getString(4));
                element.addElement(rs.getInt(5));
                element.addElement(rs.getString(6));
                element.addElement(rs.getString(7));
                element.addElement(rs.getString(8));
                element.addElement(rs.getString(9));
                element.addElement(rs.getString(10));
                list.addElement(element);
                i++;
            }
            con.close();
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
