/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hinh;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class Hinh implements HinhHoc {
 private double r;

    public Hinh(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double cv() {
        return pi * 2 * r;
    }

    public double dt() {
        return pi * r * r;
    }

    public void printCv() {
        System.out.println("Chu vi = " + cv());
    }

    public void printDt() {
        System.out.println("Dien tich = " + dt());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Nhap ban kinh: ");
        double bk = in.nextDouble();
        Hinh htr = new Hinh(bk) {};
        htr.printCv();
        htr.printDt();
    }

}
