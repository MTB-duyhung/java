/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class URLDao {

    public boolean addURL(URL u) throws Exception {
        try {
            Connection con = DBUtil.openConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO URL(shortURL,originalURL) VALUES (?,?)");
            stmt.setString(1, u.getShortURL());
            stmt.setString(2, u.getOriginalURL());

            int rowCount = stmt.executeUpdate();
            con.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<URL> getAllURL() {
        try {
            URL u = null;
            Connection con = DBUtil.openConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM URL");
            ResultSet rs = stmt.executeQuery();
            List<URL> list = new ArrayList<URL>();
            while (rs.next()) {
                u = new URL(rs.getString(1), rs.getString(2));
                list.add(u);
            }
            con.close();
            return list;

        } catch (Exception ex) {
        }
        return null;
    }

    public String shortToOriginal(String shortURL) {
        String originalURL = null;
        try {
            Connection con = DBUtil.openConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT originalURL FROM URL where shortURL='" + shortURL + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                originalURL = rs.getString(1);
            }
            con.close();
        } catch (Exception ex) {
        }
        return originalURL;
    }
}
