/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import edu.fud.dao.GroupDAO;
import edu.fud.model.GroupInfo;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListGroupActionSupport extends ActionSupport{
    public static List<GroupInfo> dsn;
    private GroupDAO daog = new GroupDAO();

    public ListGroupActionSupport() {
    }

    public ListGroupActionSupport(List<GroupInfo> dsn) {
        this.dsn = dsn;
    }

    
    public List<GroupInfo> getDsn() {
        return dsn;
    }

    public void setDsn(List<GroupInfo> dsn) {
        this.dsn = dsn;
    }

    public GroupDAO getDao() {
        return daog;
    }

    public void setDao(GroupDAO daog) {
        this.daog = daog;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    @Override
    public String execute() throws Exception {
        dsn = daog.getAllGroupInfos();
        return "success";
    }
    
    
}
