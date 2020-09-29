package triangle;

import static java.lang.Math.sqrt;
import java.util.*;

public class Triangle {

    protected float lengthFirstSide ;
    protected float lengthSecondSide ;
    protected float lengthThirdSide ;
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
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return true;
        } else {
            return false;
        }
    }

    void printKind() {
        if (check(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
            if (equilateral(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
                System.out.println("The triangle is an equilateral triangle!");
            } else if (isosceles(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
                if (right(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
                    System.out.println("The triangle is an isosceles right triangle!");
                } else {
                    System.out.println("The triangle is an isosceles triangle!");
                }
            } else if (right(lengthFirstSide, lengthSecondSide, lengthThirdSide) == true) {
                System.out.println("The triangle is a right triangle!");
            } else {
                System.out.println("The triangle is a normal triangle!");
            }
        }
    }

    @Override
    public String toString() {
        return "Triangle{" + "lengthFirstSide=" + lengthFirstSide + ", lengthSecondSide=" + lengthSecondSide + ", lengthThirdSide=" + lengthThirdSide + '}';
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle();
        tri.readLength();
//        System.out.println("c2=" + tri.lengthThirdSide * tri.lengthThirdSide);
        tri.printCheck();
//        tri.printPerimeter();
//        tri.printArea();
        tri.printKind();
    }

}
