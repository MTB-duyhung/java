/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ResizableCircle extends Circle implements Resizeable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    public ResizableCircle() {
    }

    @Override
    public double resize(int percent) {
        return radius = radius * (percent / 100.00);
    }

    @Override
    public String toString() {
        Scanner in=new Scanner(System.in);
        System.out.print("Input percent: ");
        int x=in.nextInt();
        return "Resizable Circle with radius=" + resize(x) + ", perimeter="+getPerimeter()+", area="+getArea();
    }

}
