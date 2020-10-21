/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhotoDAO {

    public ArrayList<Photo> getPhoto() throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Photo ";

        ArrayList<Photo> list = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String image = ".\\Photo Album - www.simplesite.com_us-123wedding_files\\" + rs.getString(2);
                list.add(new Photo(id, image));
            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.close(con, ps, rs);
        }
    }
}
