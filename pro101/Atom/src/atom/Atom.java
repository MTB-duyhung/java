package atom;

import java.util.Scanner;

public class Atom {

    private int number;
    private String symbol, fullname;
    private float weight;
    Scanner sc = new Scanner(System.in);
    Atom(){}
    void accept() {
        System.out.println("Enter atomic number: ");
        number = sc.nextInt();
        System.out.println("Enter symbol: ");
        symbol = sc.next();
        System.out.println("Enter full name: ");
        fullname = sc.next();
        System.out.println("Enter atomic weight: ");
        weight = sc.nextFloat();
    }

    void display() {
        System.out.println(number + " " + symbol + " " + fullname + " " + weight);
    }

    public static void main(String[] args) {
        Atom at = new Atom();
        for (int i = 0; i < 3; i++) {
            at.accept();
            at.display();
        }
    }

}
