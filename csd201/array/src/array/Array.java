/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Array {

    /**
     * @param args the command line arguments
     */
    int[] a;
    int n;

    public void input() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter element:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]=");
            a[i] = in.nextInt();
        }
    }

    public void output() {
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }
    }

    public void odd() {
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                System.out.println("a[" + i + "]=" + a[i]);
            }
        }
    }

    public void ave() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        System.out.println("Average=" + (sum / n));
    }

    public void count(int x, int y) {
        int count = 0;
        for (int i = x; i < y; i++) {
            count += 1;
        }
        System.out.println("There are " + count + " elements of array A in [" + x + ";" + y + "]");
    }

    public void search(int x) {
        int check = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                System.out.println("Found " + x + " at position " + i);
            }
            check = 1;
        }
        if (check != 0) {
            System.out.println("Not found!");
        }
    }

    public void rev() {
        int tmp = 0;
        for (int i = 1; i < n / 2; i++) {
            tmp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = tmp;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array arr = new Array();
        System.out.println("Enter number elements of array: ");
        arr.n = sc.nextInt();
        arr.a = new int[arr.n];
        while (true) {
            System.out.println("1. Input");
            System.out.println("2. Output");
            System.out.println("3. Print odd number");
            System.out.println("4. Average");
            System.out.println("5. Count elements in [x, y]");
            System.out.println("6. Search x");
            System.out.println("7. Reverse");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    arr.input();
                    break;
                case 2:
                    arr.output();
                    break;
                case 3:
                    arr.odd();
                    break;
                case 4:
                    arr.ave();
                    break;
                case 5:
                    System.out.println("x=");
                    int x = sc.nextInt();
                    System.out.println("y=");
                    int y = sc.nextInt();
                    arr.count(x, y);
                    break;
                case 6:
                    System.out.println("x=");
                    int z = sc.nextInt();
                    arr.search(z);
                    break;
                case 7:
                    arr.rev();
                case 8:
                    return;
            }
        }
    }
}
