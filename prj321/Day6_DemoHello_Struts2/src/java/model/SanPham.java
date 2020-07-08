/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maSP,tenSP;
    private double gia;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, double gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
}
