/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.formatDate;
import entity.Home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class homeDAO {

    private final DBContext db;

    public homeDAO() throws Exception {
        db = new DBContext();
    }

    public Home getDetailsPost(int id) throws Exception {

        Home home = null;
        String query = "select * from Home where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString(2);
                String img = ".//Home_files//" + rs.getString(3);
                String content = rs.getString(4);
                Date date = rs.getDate(5);
                String link=rs.getString(6);
                home = new Home(id, title, img, content, date, link);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
        return home;
    }

    public ArrayList<Home> getPost(int top) throws Exception {
        ArrayList<Home> homes = new ArrayList<>();
        String query = "select top "+top+" * from Home order by date desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String img = ".//Home_files//" + rs.getString(3);
                String content = rs.getString(4);
                Date date = rs.getDate(5);
                String link=rs.getString(6);
                Home home = new Home(id, title, img, content, date, link);
                homes.add(home);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
        return homes;
    }
}
