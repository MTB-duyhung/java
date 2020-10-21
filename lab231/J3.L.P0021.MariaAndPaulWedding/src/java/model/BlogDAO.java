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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BlogDAO {

    public ArrayList<Blog> getAllBlog() throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Blog ";

        ArrayList<Blog> list = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                Date date = rs.getDate(3);
                String content = rs.getString(5);
                Blog blog;
                if (rs.getString(4) != null) {
                    String image = ".\\Wedding Blog - www.simplesite.com_us-123wedding_files\\" + rs.getString(4);
                    blog = new Blog(id, title, date, image, content);
                } else {
                    blog = new Blog(id, title, date, content);
                }
                list.add(blog);
            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.close(con, ps, rs);
        }
    }

    public Blog getBlog(int id) throws Exception {
        try {
            Blog b = null;
            Connection con = DBContext.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Blog WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                Date date = rs.getDate(3);
                String img = null;
                if (rs.getString(4) != null) {
                    img = ".\\Wedding Blog - www.simplesite.com_us-123wedding_files\\" + rs.getString(4);
                }
                String content = rs.getString(5);
                b = new Blog(id, title, date, img, content);
            }
            con.close();
            return b;

        } catch (Exception ex) {
        }
        return null;
    }
}
