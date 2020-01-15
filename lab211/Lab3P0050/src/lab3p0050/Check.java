/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0050;

/**
 *
 * @author Admin
 */
public class Check {

    public Check() {

    }

    public boolean checkOdd(double n) {
        if (n % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }

    public void superlativeEquation() {
        System.out.print("Enter A: ");
        double a = Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Validation.checkInputDouble();
        double x = -b / a;
        System.out.println("Solution: x=" + x);

        System.out.print("Number is odd:");
        if (checkOdd(a)) {
            System.out.print(a + ",");
        }
        if (checkOdd(b)) {
            System.out.print(b + ",");
        }
        if (checkOdd(x)) {
            System.out.print(x + ",");
        }
        System.out.print("\nNumber is even: ");
        if (checkEven(a)) {
            System.out.print(a + ",");
        }
        if (checkEven(b)) {
            System.out.print(b + ",");
        }
        if (checkEven(x)) {
            System.out.print(x + ",");
        }
        System.out.print("\nNumber is perfect square: ");
        if (checkSquareNumber(a)) {
            System.out.print(a + ",");
        }
        if (checkSquareNumber(b)) {
            System.out.print(b + ",");
        }
        if (checkSquareNumber(x)) {
            System.out.print(x + ",");
        }
        System.out.println("\n");
    }

    public void quadraticEquation() {
        System.out.print("Enter A: ");
        double a = Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Validation.checkInputDouble();
        System.out.print("Enter C: ");
        double c = Validation.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        if (delta < 0) {
            System.out.println("No solution");
        } else if (delta == 0) {
            System.out.println("Solution: x1=x2=" + (-b / (2 * a)));
        }
        System.out.println("Solution: x1=" + x1 + "and x2=" + x2);
        System.out.print("Number is odd");
        if (checkOdd(a)) {
            System.out.print(a + ",");
        }
        if (checkOdd(b)) {
            System.out.print(b + ",");
        }
        if (checkOdd(c)) {
            System.out.print(c + ",");
        }
        if (checkOdd(x1)) {
            System.out.print(x1 + ",");
        }
        if (checkOdd(x2)) {
            System.out.print(x2 + ",");
        }
        System.out.print("\nNumber is even: ");
        if (checkEven(a)) {
            System.out.print(a + ",");
        }
        if (checkEven(b)) {
            System.out.print(b + ",");
        }
        if (checkEven(c)) {
            System.out.print(c + ",");
        }
        if (checkEven(x1)) {
            System.out.print(x1 + ",");
        }
        if (checkEven(x2)) {
            System.out.print(x2 + ",");
        }
        System.out.print("\nNumber is perfect square: ");
        if (checkSquareNumber(a)) {
            System.out.print(a + ",");
        }
        if (checkSquareNumber(b)) {
            System.out.print(b + ",");
        }
        if (checkSquareNumber(c)) {
            System.out.print(c + ",");
        }
        if (checkSquareNumber(x1)) {
            System.out.print(x1 + ",");
        }
        if (checkSquareNumber(x2)) {
            System.out.print(x2 + ",");
        }
        System.out.println("\n");
    }
}
