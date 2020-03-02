/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Stack {

    int S[];
    int top;
    int MAX = 100;

    Stack() {
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
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number elements: n= ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter: x= ");
            int x = sc.nextInt();
            push(x);
        }
    }

    void output() {
        while (top > -1) {
            int x = pop();
            System.out.println(x + " ");
        }
    }

    void clear() {
        top = -1;
    }

    int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return S[top];
        }
    }

    public static void main(String[] args) {
        Stack S = new Stack();
        S.input();
        S.output();
    }

}
