/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.controller;

import Validate.Validate;
import com.opensymphony.xwork2.ActionSupport;
import static edu.fud.controller.ListGroupActionSupport.dsn;
import edu.fud.dao.GroupDAO;
import edu.fud.model.GroupInfo;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AddGroupActionSupport extends ActionSupport {

    String Groupname, description, errorg;
    public List<GroupInfo> dsn;
    private GroupDAO daog = new GroupDAO();

    public String getGroupname() {
        return Groupname;
    }

    public void setGroupname(String Groupname) {
        this.Groupname = Groupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorg() {
        return errorg;
    }

    public void setErrorg(String errorg) {
        this.errorg = errorg;
    }

    public List<GroupInfo> getDsn() {
        return dsn;
    }

    public void setDsn(List<GroupInfo> dsn) {
        this.dsn = dsn;
    }

    public GroupDAO getDaog() {
        return daog;
    }

    public void setDaog(GroupDAO daog) {
        this.daog = daog;
    }

    public String execute() throws Exception {
        String erString = "Some fields is empty. ";
        System.out.println("name= " + Groupname + "  " + description);
        if (!Validate.checkString(Groupname) || !Validate.checkString(description)) {
            if (errorg != null) {
                errorg += erString;
            } else {
                errorg = erString;
            }
        }
        if (errorg != null) {
            return "error";
        }
        if (daog.insert(Groupname, description)) {
            dsn = daog.getAllGroupInfos();
            System.out.println(dsn.size());
            return "success";
        }
        return "fail";
    }
}
