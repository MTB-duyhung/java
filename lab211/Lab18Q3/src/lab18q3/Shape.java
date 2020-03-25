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
public class Shape {

    String color;
    boolean filled;

    public Shape() {
        color = "green";
        filled = true;
    }

    public Shape(String color) {
        this.color = color;
        this.filled = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String x;
        if (filled) {
            x = "filled";
        } else {
            x = "not filled";
        }
        return "A Shape with color of " + color + " and " + x;
    }

}
