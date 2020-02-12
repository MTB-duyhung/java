/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogLibDB {
 //---------------------------------------------------------------------------------------
//    public static LogLib getLog(int logid){
//        LogLib l = null;
//        try {
//            Connection con;
//            con=ConnectDB.getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("Select userID, bookID, maNV, ngayDat, ngayMuon, ngayPtra, ngayTra from LogLib where logID='" + logid + "'");
//            if (rs.next()) {
//                String userID = rs.getString(1);
//                String bookID = rs.getString(2);
//                String maNV = rs.getString(3);
//                String keyword = rs.getString(4);
//                int logID = logid;
//                l = new LogLib(userID, bookID, maNV, logID, ngayDat,ngayMuon, ngayPtra, ngayTra);
//            }
//            con.close();
//            return b;
//        } catch (Exception ex) {
//            Logger.getLogger(BookDB.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
 //---------------------------------------------------------------------------------------
    public static void updateLog(LogLib log){
        
    }
 //---------------------------------------------------------------------------------------
    public static int writeLog(LogLib log){
        return -1;
    }
 //---------------------------------------------------------------------------------------   
    public static Vector<Vector> viewLogByUser(String uid){
        return null;
    }
 //---------------------------------------------------------------------------------------   
    public static ArrayList<LogLib> getLogsByUser(String uid){
        return null;
    }
}
