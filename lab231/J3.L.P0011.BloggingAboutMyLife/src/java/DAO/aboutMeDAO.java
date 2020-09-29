/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectDB;
import model.aboutMe;

/**
 *
 * @author Admin
 */
public class aboutMeDAO {

    public aboutMe getMe() throws ClassNotFoundException, SQLException {
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stmt = con.prepareStatement("Select * from aboutMe");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String detail = rs.getString("detail");
                String name = rs.getString("name");
                aboutMe x = new aboutMe(detail, name);
                return x;
            }
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(aboutMeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
