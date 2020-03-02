/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttree;

/**
 *
 * @author Admin
 */
public class Queue {

    Node Q[];
    int MAX = 100;
    int f, l;

    Queue() {
        Q = new Node[MAX];
        f = l = -1;
    }

    void clear() {

    }

    boolean isEmpty() {
        return (f == -1)||(f>l);
    }

    void full() {
        int x = 0;
        if ((f > 0) && (l == MAX - 1)) {
            for (int i = f; i <= l; i++) {
                Q[x] = Q[f];
                x++;
            }
        }
    }

    void enqueue(Node x) {
        if ((f == 0) && (l == MAX - 1)) {
            System.out.println("Queue is full");
        } else {
            l++;
            Q[l] = x;
            if (f == -1) {
                f = 0;
            }
        }
    }

    Node dequeue() {
        Node x = null;
        if (isEmpty()) {
            System.out.println("Q is empty");
        } else {
            x = Q[f];
            f++;
        }
        return x;
    }
}
