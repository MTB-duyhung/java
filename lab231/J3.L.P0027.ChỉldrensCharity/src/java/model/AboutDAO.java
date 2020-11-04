/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.About;
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
public class AboutDAO {

    private final DBContext db;

    public AboutDAO() throws Exception {
        db = new DBContext();
    }

    public ArrayList<About> getPost() throws Exception {
        ArrayList<About> abouts = new ArrayList<>();
        String query = "select * from About ";
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
                String content = rs.getString(3);
                About about=null;
                if (rs.getString(4) != null) {
                    String img = ".//About Our School_files//" + rs.getString(4);
                    about = new About(id,title, content, img);
                }else{
                    about = new About(id,title, content);
                }
                abouts.add(about);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
        return abouts;
    }
}
