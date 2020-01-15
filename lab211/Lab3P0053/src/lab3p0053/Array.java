/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0053;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Array {

    int[] m = new int[100];
    int n;
    Scanner in = new Scanner(System.in);

    public int inputSizeOfArray() {
        System.out.print("Enter number of elements: ");
        n = in.nextInt();
        return n;
    }

    public void inputValueOfArray() {
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("m[" + i + "]= ");
            m[i] = in.nextInt();
        }
    }

    public void sortArrayAscending() {
        int i, j;
        if (n == 0) {
            System.out.println("List Empty");
        }
        for (i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (m[j] < m[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = m[minIndex];
                m[minIndex] = m[i];
                m[i] = temp;
            }
        }
        System.out.println();
        for (i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print("[" + m[i] + "]");
                break;
            }
            System.out.print("[" + m[i] + "]->");
        }
        System.out.println();
    }

    public void sortArrayDescending() {
        int i, j;
        if (n == 0) {
            System.out.println("List Empty");
        }
        for (i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (m[j] > m[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = m[minIndex];
                m[minIndex] = m[i];
                m[i] = temp;
            }
        }
        System.out.println();
        for (i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print("[" + m[i] + "]");
                break;
            }
            System.out.print("[" + m[i] + "]->");
        }
        System.out.println();
    }
}
