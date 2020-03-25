/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q2;

/**
 *
 * @author Admin
 */
public class Lab18Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println(c1.toString());
        Cylinder c2 = new Cylinder(10.0);
        System.out.println(c2.toString());
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println(c3.toString());
    }
}
