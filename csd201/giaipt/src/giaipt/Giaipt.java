/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaipt;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Giaipt {

    public static void ptb1(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            System.out.println("Phuon g trinh co nghiem x=" + (-b / a));
        }
    }

    public static void ptb2(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem.");
        } else if (delta == 0) {
            System.out.println("Phuong trinh co nghiem kep " + (double) (-b / (2 * a)));
        } else {
            System.out.println("Phuong trinh co 2 nghiem: x1=" + (-b + Math.sqrt(delta)) / (2 * a) + ", x2=" + (-b - Math.sqrt(delta)) / (2 * a));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
            int choice = in.nextInt();
            System.out.println("Enter a:");
            a = in.nextDouble();
            
            System.out.println("Enter b:");
            b = in.nextDouble();

            System.out.println("Enter c:");
            c = in.nextDouble();

            if (a==0) ptb1(b,c);
            else ptb2(a,b,c);
        
    }
}

