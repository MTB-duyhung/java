/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Photo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhotoDAO {
    
    private final DBContext db;

    public PhotoDAO() throws Exception {
        db = new DBContext();
    }
    public ArrayList<Photo> getPost() throws Exception {
        ArrayList<Photo> photos = new ArrayList<>();
        String query = "select * from Photo ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String img=rs.getString(2);
                Photo photo=null;
                photo=new Photo(id, img);
                photos.add(photo);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
        return photos;
    }
}
