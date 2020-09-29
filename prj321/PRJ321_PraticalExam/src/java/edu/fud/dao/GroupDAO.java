/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.dao;

import edu.fud.connect.DBconnect;
import edu.fud.model.GroupInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupDAO {
    //List all GroupInfos
    public List<GroupInfo> getAllGroupInfos() throws Exception{
        List<GroupInfo> list = new ArrayList();
        String sql = "select * from [GroupDB]";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                GroupInfo gr = new GroupInfo();
                gr.setID(rs.getInt("ID"));
                gr.setGroupname(rs.getString("GroupName"));
                gr.setDescription(rs.getString("Description")); 
                list.add(gr);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean insert(String name, String des){
        try {
            Connection con = DBconnect.getConnection();
            String sql = "INSERT INTO [GroupDB] (GroupName, Description) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, des);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
}
