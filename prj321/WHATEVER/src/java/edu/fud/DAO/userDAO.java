/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.DAO;

import edu.fud.model.User;
import static edu.fud.model.databaseInfo.dbURL;
import static edu.fud.model.databaseInfo.driverName;
import static edu.fud.model.databaseInfo.passDB;
import static edu.fud.model.databaseInfo.userDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang My
 */
public class userDAO {

    public static void addNewUser(User us) {
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO UserInformation(UserID, Name, UserName,PassWord,Email,UserRight,)" + " VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, us.getUserID());
            stmt.setString(2, us.getName());
            stmt.setString(3, us.getUserName());
            stmt.setString(4, us.getPassword());
            stmt.setString(5, us.getEmail());
            stmt.setInt(6, us.getUserRight());
            int rc = stmt.executeUpdate();
            con.close();
            if (rc != 1) {
                throw new RuntimeException("Add new user failed !");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean deleteUser(String uid) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("Delete FROM UserInformation where UserID = ?");
            stmt.setString(1, uid);
            int rowCount = stmt.executeUpdate();
            con.close();
            return rowCount == 1;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateUser(User us) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {

        }
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
            PreparedStatement stmt = con.prepareStatement("UPDATE UserInformation SET UserID =?, Name=?, UserName=?,PassWord=?,Email=?,UserRight=?");
            stmt.setString(1, us.getUserID());
            stmt.setString(2, us.getName());
            stmt.setString(3, us.getUserName());
            stmt.setString(4, us.getPassword());
            stmt.setString(5, us.getEmail());
            stmt.setInt(6, us.getUserRight());
            int rc = stmt.executeUpdate();
            con.close();
            if (rc != 1) {
                throw new RuntimeException("User update failed");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static User getUser(String uid) {
        User u = null;
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select Name, UserName,PassWord,Email,UserRight from Users where UserID='" + uid + "'");
            if (rs.next()) {
                String Name = rs.getString(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                int userRight = rs.getInt(5);
                String userID = uid;
                u = new User(userID, Name, userName, password, email, userRight);
            }
            con.close();
            return u;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Vector<Vector> getLogsByUser(String uid) {
        try {
            Vector<Vector> logs = new Vector<>();
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("SELECT BookID,Time FROM Library WHERE UserID=?");
            stmt.setString(1, uid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vector log = new Vector();
                log.addElement(rs.getString(1));
                log.addElement(rs.getDate(2));
                logs.addElement(log);
            }
            con.close();
            return logs;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     public static Vector<Vector> viewLogByUser(String uid) {
        Vector<Vector> logs = getLogsByUser(uid);
        for (int i = 0; i < logs.size(); i++) {
            for (int j = 0; j < logs.get(i).size(); j++) {
                System.out.print(logs.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return logs;
    }
     
}
