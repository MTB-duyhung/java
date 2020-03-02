/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltobinaryusestack;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DecimalToBinaryUseStack {

    int S[];
    int top;
    int MAX = 100;

    DecimalToBinaryUseStack() {
        S = new int[MAX];
        top = -1;
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    void push(int x) {
        if (top == MAX) {
            System.out.println("Stack is full");
        } else {
            top++;
            S[top] = x;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int x = S[top];
            top--;
            return x;
        }
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter decimal number: ");
        n = sc.nextInt();
        while (n != 0) {
            int q = n / 2;
            int r = n % 2;
            push(r);
            n = q;
        }
    }

    void output() {
        System.out.print("Binary number: ");
        if (top == -1) {
            System.out.print("0000");
        }
        while ((top + 1) % 4 != 0) {
            push(0);
        }
        while (top > -1) {
            int x = pop();
            System.out.print(x);
        }
    }

    void clear() {
        top = -1;
    }

    int top() {
        return S[top];
    }

    public static void main(String[] args) {
        DecimalToBinaryUseStack S = new DecimalToBinaryUseStack();
        S.input();
        S.output();
    }

}
