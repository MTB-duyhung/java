/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

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

    Node(int x, Node p) {
        data = x;
        next = p;
    }

    Node(int x) {
        this(x, null);
    }
}

public class LinkedList {

    Node head, tail;//pointers point to the first node & last

    LinkedList() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void addlast(int x) {//add x to the end of list
        Node q = new Node(x);//q.data=x;q.next=null
        if (isEmpty()) {
            head = q;
            tail = q;
        }
        tail.next = q;//tra toi node q
        tail = q;//di chuyen toi node q
    }

    void traverse() {//duyet ds
        Node p = head;
        while (p != null) {
            System.out.print(p.data);
            p = p.next;//chuyen qua pt ke tiep
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

    Node searchPos(int pos) {
        Node p = head;
        int count = 0;
        while (p != null && count != pos) {
            p = p.next;
            count++;
        }
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }

    void insert(int x, int pos) {
        Node Q = new Node(x);
        Node q = searchPos(pos - 1);
        if (q != null) {
            Q.next = q.next;
            q.next = Q;
        }
    }

    void delete(int pos) {
        Node p = searchPos(pos);
        Node q = searchPos(pos - 1);
        if (q != null) {
            q.next = p.next;
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
            addlast(x);
        }
    }

    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        L.input();
        //L.insert(9, 2);
        L.search(10);
        //L.traverse();
//        System.out.println("\ndelete");
//        L.delete(2);
//        L.traverse();
//        L.search(7);
//        Node q = L.searchPos(2);
//        if (q != null) {
//            System.out.println("\n" + q.data + " at position 2");
//        }
    }

}
