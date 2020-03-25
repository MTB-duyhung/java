/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q1;

/**
 *
 * @author Admin
 */
public class Lab18Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p;
        p=new Student("Nhan", "QB", "A", 2, 100);
        System.out.println(p.toString());
        p=new Staff("Hoa", "DN", "FPT", 500);
        System.out.println(p.toString());
    }
    
}
