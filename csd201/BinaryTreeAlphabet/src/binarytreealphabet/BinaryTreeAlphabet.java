/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreealphabet;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
class Node {

    char a;
    int data = (int) a;
    Node l, r;//left, right

    Node() {

    }

    Node(char x) {
        data = (int) x;
        l = r = null;
    }

}

class Queue {

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
        return (f == -1) || (f > l);
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

public class BinaryTreeAlphabet {

    Node root;

    BinaryTreeAlphabet() {
        root = null;
    }

    void PreOrder(Node root) {
        if (root != null) {
            System.out.print((char) root.data + "");
            PreOrder(root.l);
            PreOrder(root.r);

        }
    }

    void Pre() {
        PreOrder(root);
    }

    void PostOrder(Node root) {
        if (root != null) {
            PostOrder(root.l);
            PostOrder(root.r);
            System.out.print((char) root.data + "");
        }
    }

    void Post() {
        PostOrder(root);
    }

    void InOrder(Node root) {
        if (root != null) {
            InOrder(root.l);
            System.out.print((char) root.data + "");
            InOrder(root.r);
        }
    }

    void In() {
        InOrder(root);
    }

    Node insertRec(char x, Node root) {
        if (root == null) {
            root = new Node(x);
            return root;
        } else if (x < root.data) {
            root.l = insertRec(x, root.l);
        } else if (x > root.data) {
            root.r = insertRec(x, root.r);
        } else {
            System.out.println("trung");
        }
        return root;
    }

    void insert(char x) {
        root = insertRec(x, root);
    }

    Node search(char x, Node root) {
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            return root;
        }
        if (x < root.data) {
            return search(x, root.l);
        } else {
            return search(x, root.r);
        }
    }

    Node delRec(char x, Node root) {
        if (root == null) {
            return root;
        }
        if (x < root.data) {
            root.l = delRec(x, root.l);
        } else if (x > root.data) {
            root.r = delRec(x, root.r);
        } else if (x == root.data) {
            if (root.l == null) {
                return root.r;
            } else if (root.r == null) {
                return root.l;
            } else {
                root.data = minNode(root.r);
            }
            root.r = delRec((char) root.data, root.r);
        }
        return root;
    }

    int minNode(Node root) {
        int m = root.data;
        while (root.l != null) {
            m = root.l.data;
            root = root.l;
        }
        return m;
    }

    void Delete(char x) {
        delRec(x, root);
    }

    void BFT() {
        if (root == null) {
            System.out.println("Tree is null");
            return;
        }
        Queue Q = new Queue();
        Q.enqueue(root);
        Node p;
        while (!Q.isEmpty()) {
            p = (Node) Q.dequeue();
            if (p.l != null) {
                Q.enqueue(p.l);
            }
            if (p.r != null) {
                Q.enqueue(p.r);
            }
            System.out.print((char) p.data + "");
        }
    }

    void input() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number elements: n= ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter: ");
            char x = sc.next().charAt(0);
            insert(x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BinaryTreeAlphabet bt = new BinaryTreeAlphabet();
        bt.input();
        System.out.print("\nPre Order: ");
        bt.Pre();
        System.out.print("\nIn Order: ");
        bt.In();
        System.out.print("\nPost Order: ");
        bt.Post();
        System.out.print("\nBTF: ");
        bt.BFT();
        System.out.print("\nEnter character to delete: ");
        char d = in.next().charAt(0);
        bt.Delete(d);
        System.out.print("\nPre Order after delete 'c': ");
        bt.Pre();
        System.out.print("\nEnter character to search: ");
        char s = in.next().charAt(0);
        Node p = bt.search(s, bt.root);
        if (p != null) {
            System.out.print("Found " + (char) p.data);
        } else {
            System.out.println("Not found");
        }
    }

}
