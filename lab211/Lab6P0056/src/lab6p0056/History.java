/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0056;

/**
 *
 * @author Admin
 */
public class History extends Worker implements Comparable<History>{
    protected String status;
    protected String date;

    public History() {
    }

    public History(String status, String date, String id, String name, int age, int salary, String worlLocation) {
        super(id, name, age, salary, worlLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public int compareTo(History o) {
        return o.getId().compareTo(this.getId());
    }
    
    
}
