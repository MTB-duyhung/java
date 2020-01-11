/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class Course implements Comparable<Course> {

    private String id;
    private String name;
    private int numberOfCredit;

    public Course(String id, String name, int numberOfCredit) {
        this.id = id;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
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

    public double getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    @Override
    public int compareTo(Course t) {
        return t.numberOfCredit >= numberOfCredit ? -1 : 0;
    }

    public Set<Course> sort(List<Course> list) {
        Set<Course> result = new TreeSet<>();
        for (Course course : list) {
            result.add(course);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", numberOfCredit=" + numberOfCredit + '}';
    }

    public void print() {
        System.out.printf("%-15s%-15s%-15d\n", id, name, numberOfCredit);
    }

}
