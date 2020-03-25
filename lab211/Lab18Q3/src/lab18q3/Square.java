/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q3;

/**
 *
 * @author Admin
 */
public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color) {
        super(side, side, color);
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.length = this.width = side;
    }

    public void setWidth(double side) {
        this.width = side;
    }

    public void setLength(double side) {
        this.length = side;
    }

    @Override
    public String toString() {
        Rectangle r=new Rectangle();
        return "A Square with side=" + length+", which is a subclass of "+r.toString();
    }

}
