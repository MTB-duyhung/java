/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryNhan;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class LogLib {

    private String userID, bookID, maNV;
    private int logID;
    private Date ngayDat, ngayMuon, ngayPtra, ngayTra;

    public LogLib() {

    }

    public LogLib(String userID, String bookID, String maNV, int logID, Date ngayDat, Date ngayMuon, Date ngayPtra, Date ngayTra) {
        this.userID = userID;
        this.bookID = bookID;
        this.maNV = maNV;
        this.logID = logID;
        this.ngayDat = ngayDat;
        this.ngayMuon = ngayMuon;
        this.ngayPtra = ngayPtra;
        this.ngayTra = ngayTra;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayPtra() {
        return ngayPtra;
    }

    public void setNgayPtra(Date ngayPtra) {
        this.ngayPtra = ngayPtra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    @Override
    public String toString() {
        return "LogLib{" + "userID=" + userID + ", bookID=" + bookID + ", maNV=" + maNV + ", logID=" + logID + ", ngayDat=" + ngayDat + ", ngayMuon=" + ngayMuon + ", ngayPtra=" + ngayPtra + ", ngayTra=" + ngayTra + '}';
    }

}
