package triangle;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import java.util.*;

public class Triangle {

    protected float lengthFirstSide;
    protected float lengthSecondSide;
    protected float lengthThirdSide;
    Scanner in = new Scanner(System.in);

    public float getLengthFirstSide() {
        return lengthFirstSide;
    }

    public void setLengthFirstSide(float lengthFirstSide) {
        this.lengthFirstSide = lengthFirstSide;
    }

    public float getLengthSecondSide() {
        return lengthSecondSide;
    }

    public void setLengthSecondSide(float lengthSecondSide) {
        this.lengthSecondSide = lengthSecondSide;
    }

    public float getLengthThirdSide() {
        return lengthThirdSide;
    }

    public void setLengthThirdSide(float lengthThirdSide) {
        this.lengthThirdSide = lengthThirdSide;
    }

    void readLength() {

        do {
            System.out.print("Enter length of First Side(1<=a<=200):");
            lengthFirstSide = in.nextFloat();
        } while (lengthFirstSide < 1 || lengthFirstSide > 200);
        do {
            System.out.print("Enter length of Second Side(1<=b<=200):");
            lengthSecondSide = in.nextFloat();
        } while (lengthSecondSide < 1 || lengthSecondSide > 200);
        do {
            System.out.print("Enter length of Third Side(1<=c<=200):");
            lengthThirdSide = in.nextFloat();
        } while (lengthThirdSide < 1 || lengthThirdSide > 200);
    }

    boolean check(float a, float b, float c) {
        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            return true;
        } else {
            return false;
        }
    }

    void printCheck() {
        if (check(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
            System.out.println("The triangle is valid!");
        } else {
            System.out.println("The triangle is invalid!");
        }
    }

    float perimeter() {
        return lengthFirstSide + lengthSecondSide + lengthThirdSide;
    }

    void printPerimeter() {
        if (check(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
            System.out.println("The perimeter of the triangle = " + perimeter());
        }
    }

    double area() {
        return Math.sqrt(perimeter() / 2 * (perimeter() / 2 - lengthFirstSide)
                * (perimeter() / 2 - lengthSecondSide) * (perimeter() / 2 - lengthThirdSide));
    }

    void printArea() {
        if (check(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
            System.out.println("The area of the triangle = " + area());
        }
    }

    boolean isosceles(float a, float b, float c) {
        if (a == b || b == c || a == c) {
            return true;
        } else {
            return false;
        }
    }

    boolean equilateral(float a, float b, float c) {
        if (a == b && b == c && a == c) {
            return true;
        } else {
            return false;
        }
    }

    boolean right(float a, float b, float c) {
        if (a * a + b * b == round(c * c * 100) / 100 || a * a + c * c == round(b * b * 100) / 100 || b * b + c * c == round(a * a * 100) / 100) {
            return true;
        } else {
            return false;
        }
    }

    int kind(float a, float b, float c) {
        if (check(a, b, c) == true) {
            if (equilateral(a, b, c) == true) {
                return 3;
            } else if (isosceles(a, b, c) == true) {
                if (right(a, b, c) == true) {
                    return 5;
                } else {
                    return 2;
                }
            } else if (right(a, b, c) == true) {
                return 4;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    void printKind() {
        if (kind(lengthFirstSide, lengthSecondSide, lengthThirdSide) == 0) {
            System.out.println("This is not a triangle");
        } else if (kind(lengthFirstSide, lengthSecondSide, lengthThirdSide) == 1) {
            System.out.println("The triangle is a normal triangle!");
        } else if (kind(lengthFirstSide, lengthSecondSide, lengthThirdSide) == 2) {
            System.out.println("The triangle is an isosceles triangle!");
        } else if (kind(lengthFirstSide, lengthSecondSide, lengthThirdSide) == 3) {
            System.out.println("The triangle is an equilateral triangle!");
        } else if (kind(lengthFirstSide, lengthSecondSide, lengthThirdSide) == 4) {
            System.out.println("The triangle is a right triangle!");
        } else {
            System.out.println("The triangle is an isosceles right triangle!");
        }
    }

    @Override
    public String toString() {
        return "Triangle{" + "lengthFirstSide=" + lengthFirstSide + ", lengthSecondSide=" + lengthSecondSide + ", lengthThirdSide=" + lengthThirdSide + '}';
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle();
        tri.printKind();
    }

}
