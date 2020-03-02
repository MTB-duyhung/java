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
public class Worker {
    protected String id;
    protected String name;
    protected int age;
    protected int salary;
    protected String worlLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String worlLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.worlLocation = worlLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorlLocation() {
        return worlLocation;
    }

    public void setWorlLocation(String worlLocation) {
        this.worlLocation = worlLocation;
    }
    
    
}
