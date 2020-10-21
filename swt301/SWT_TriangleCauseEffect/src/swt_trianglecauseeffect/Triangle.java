/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swt_trianglecauseeffect;

import static java.lang.Math.round;

/**
 *
 * @author HoangMy
 */
public class Triangle {
     private int a, b, c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getName() {
        return getName(a, b, c);
    }

    public String getName(float a, float b, float c) {
        if (a + b > c && b + c > a && c + a > b) {
            if (a == b && b == c) return "Equilateral triangle";
            else if (round(a * a * 100) / 100 == b * b + c * c || round(b * b * 100) / 100 == a * a + c * c || round(c * c * 100) / 100 == a * a + b * b)
                if(a == b || b == c || c == a)
                    return "Right Isosceles triangle";
                else
                    return "Right triangle";
            else if (a == b || b == c || a == c) {
                    return "Isosceles triangle";
            }else if (a == b & b == c)
                return "Equilateral triangle";
            else
                return "Scalene triangle";
        } else
            return "Not a triangle";
    }
}
