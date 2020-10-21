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
public class GuestDAO {

    public ArrayList<GuestBook> getGuest() throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Guestbook ";

        ArrayList<GuestBook> list = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String content = rs.getString(4);
                String image = ".\\Guestbook - www.simplesite.com_us-123wedding_files\\" + rs.getString(3);
                Date date=rs.getDate(5);
                GuestBook g=new GuestBook(id, name, image, content,date);
                list.add(g);
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
