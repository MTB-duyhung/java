package RightTriangle;

import static java.lang.Math.sqrt;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RightTriangle {

    int a, b, c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public RightTriangle(int a, int b, int c)
            throws IllegalTriangleException, IllegalRightTriangleException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("");
        }
        if (sqrt(a * a + b * b) != c && sqrt(b * b + c * c) != a && sqrt(a * a + c * c) != b) {
            throw new IllegalRightTriangleException("");
        }
    }
    

    public static void main(String[] args) {
        int a, b, c;

        Scanner in = new Scanner(System.in);
        while (true) {
            try{
                System.out.println("Enter side a");
                a=in.nextInt();
                System.out.println("Enter side b");
                b=in.nextInt();
                System.out.println("Enter side c");
                c=in.nextInt();
                if (a<=0||b<=0||c<=0)
                    throw new InputMismatchException();
                    
            }catch(InputMismatchException ex){
                in.nextLine();
                System.out.println("Wrong input! Try again:\n");
                continue;
            }

            try {
                RightTriangle rt = new RightTriangle(a, b, c);
                System.out.println("This is a right triangle!");
            } catch (IllegalTriangleException e1) {
                System.out.println("This is not a triangle!");
            } catch (IllegalRightTriangleException e2) {
                System.out.println("This is not a right triangle");
            }
            System.out.print("Continue?(Y/N):");
            char chon = in.next().charAt(0);
            if (chon != 'Y') {
                break;
            }
        }
    }
}
