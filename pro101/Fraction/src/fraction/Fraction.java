package fraction;

import java.util.Scanner;

public class Fraction {

    private int numerator;
    private int denominator;

    Fraction() {
    }
    Scanner in = new Scanner(System.in);

    void getFrac() {
        do {
            System.out.print("numerator=");
            numerator = in.nextInt();
            System.out.print("denominator=");
            denominator = in.nextInt();
        } while (denominator == 0);
    }

    @Override
    public String toString() {
        if (denominator == 1 || numerator == 0) {
            return "" + numerator;
        } else {
            if (denominator < 0) {
                return "" + -numerator + "/" + -denominator;
            } else {
                return "" + numerator + "/" + denominator;
            }
        }
    }

    int gcd(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return gcd(denominator, numerator % denominator);
    }

    void reduce() {
        int i = gcd(numerator, denominator);
        if (i != 0) {
            numerator /= i;
            denominator /= i;
        }
    }

    void add(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.denominator + b.numerator * a.denominator;
        result.denominator = a.denominator * b.denominator;
        result.reduce();
        System.out.println("Add 2 fraction= " + result.toString());
    }

    void subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
        result.denominator = a.denominator * b.denominator;
        result.reduce();
        System.out.println("Subtract 2 fraction= " + result.toString());
    }

    void multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.numerator;
        result.denominator = a.denominator * b.denominator;
        result.reduce();
        System.out.println(
                "multiply 2 fraction= " + result.toString());
    }

    void divide(Fraction a, Fraction b) {
        Fraction result = new Fraction();
        result.numerator = a.numerator * b.denominator;
        result.denominator = a.denominator * b.numerator;
        result.reduce();
        System.out.println("divide 2 fraction= " + result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fraction a = new Fraction();
        Fraction b = new Fraction();
        Fraction c = new Fraction();
        a.getFrac();
        System.out.println(a.toString());
        b.getFrac();
        System.out.println(b.toString());
        c.add(a, b);
        c.subtract(a, b);
        c.multiply(a, b);
        c.divide(a, b);

    }

}
