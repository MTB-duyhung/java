/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listhash;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
class Node {

    int data;
    Node next;

    Node() {

    }

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {

    Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    void add(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void traverse() {
        Node p = head;
        if (head == null) {
            System.out.print("Null");
            return;
        }
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;

        }
    }

    void search(int x) {
        Node p = head;
        while ((p != null) && (p.data != x)) {
            p = p.next;
        }
        if (p != null) {
            System.out.println("\nFound " + x);
        } else {
            System.out.println("\nNot found " + x);
        }
    }

    void delete(int x) {
        Node p = head, q = null;
        if ((p != null) && (p.data == x)) {
            head = p.next;
            return;
        }
        while ((p != null) && (p.data != x)) {
            q = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        q.next = p.next;
    }

}

public class ListHash {

    int M;//Size of hash table
    LinkedList A[];//Hash table

    ListHash() {
    }

    ListHash(int m) {
        M = m;
        A = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            A[i] = new LinkedList();
        }
    }

    int HF(int x) {
        return x % M;//i=x%M
    }

    void addlist(int x) {
        int i = HF(x);
        A[i].add(x);
    }

    void ouput() {
        for (int i = 0; i < M; i++) {
            System.out.print("A[" + i + "]: ");
            A[i].traverse();
            System.out.println();
        }
    }

    void input() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a key: ");
            int x = in.nextInt();
            if (x == -1) {
                break;
            } else {
                addlist(x);
            }
        }
    }

    void inputRand() {
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n, x;
        System.out.print("Number of elements: ");
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            x = rd.nextInt(100);
            addlist(x);
        }

    }

    void search(int x) {
        int i = HF(x);
        A[i].search(x);
    }

    void delete(int x) {
        int i = HF(x);
        A[i].delete(x);
    }

    public static void main(String[] args) {
        ListHash h = new ListHash(5);
        h.input();
        h.ouput();
        h.search(10);
        h.delete(5);
        h.ouput();
    }

}
