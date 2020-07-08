/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class HelloActionSupport extends ActionSupport {

    private SanPham sp = new SanPham();
    private List<SanPham> dssp = new ArrayList<>();

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public List<SanPham> getDssp() {
        return dssp;
    }

    public void setDssp(List<SanPham> dssp) {
        this.dssp = dssp;
    }

    public HelloActionSupport() {
    }

    public String execute() throws Exception {
        this.sp=new SanPham("sp01", "San pham 1", 100);
        return "success";
    }

    public String hienthi() {
        this.dssp.add(new SanPham("sp01", "San pham 1", 100));
        this.dssp.add(new SanPham("sp02", "San pham 2", 200));
        this.dssp.add(new SanPham("sp03", "San pham 3", 300));
        return "success";
    }
}
