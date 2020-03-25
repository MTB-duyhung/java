/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

class Node {

    int data;
    Node left, right;//point

    Node() {
    }

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Queue {

    int Q[];
    int max = 100;
    int f, l;

    Queue(int m) {
        max = m;
        Q = new int[max];
        f = 0;
        l = 0;
    }

    int count() {
        int x = l - f;
        return x;
    }

    boolean isEmpty() {
        return count() == 0;
    }

    boolean isFull() {
        return count() == max;
    }

    void enqueue(int x) {
        if (isFull()) {
            System.err.println("Full queue!");
        } else {
            Q[l] = x;
            l = (l + 1) % max;
            if (f == -1) {
                f = 0;
            }
        }
    }

    int dequeue() {
        int x = 0;
        if (isEmpty()) {
            System.err.println("Empty queue!");
        } else {
            x = Q[f];
            f = (f + 1) % max;
        }
        return x;
    }
}

public class Graph {

    int A[][];//adjacency matrix
    int n;//nuber of vertices
    char v[];//store path;
    int color[];//color enqueue vertice
    int infiniti = 99999;

    Graph() {
        v = "ABCDEFG".toCharArray();//graph has 7 vertices 
    }

    void setData(int B[][]) {
        n = B.length;
        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = B[i][j];
            }
        }
    }

    void disp() {
        System.out.println("The adjacency matix A");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", A[i][j]);
            }
        }
    }

    void BFS(int k) {
        Queue q = new Queue(n + 1);
        boolean color[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            color[i] = false;
        }
        q.enqueue(k);
        color[k] = true;
        System.out.println("\nBFT from vertex k=" + k);
        int v;
        while (!q.isEmpty()) {
            v = q.dequeue();
            System.out.print(v);
            for (int j = 0; j < n; j++) {
                if (!color[j] && A[v][j] > 0) {
                    q.enqueue(j);
                    color[j] = true;
                }
            }
        }
    }

    void depth(boolean color[], int i) {
        System.out.print(i);
        color[i] = true;
        for (int j = 0; j < n; j++) {
            if (!color[j] && A[i][j] > 0) {
                depth(color, j);
            }
        }
    }

    void DFS(int k) {
        boolean color[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            color[i] = false;
        }
        System.out.println("\nDFT from vertex k=" + k);
        depth(color, k);

    }

    void Dijkstra(int Fnode, int Lnode) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 0 && i != j) {
                    A[i][j] = infiniti;
                }
            }
        }

        boolean s[] = new boolean[A.length];
        int dist[] = new int[A.length];

        for (int k = 0; k < A.length; k++) {
            s[k] = false;
            dist[k] = infiniti;
        }

        dist[Fnode] = 0;

        for (int x = 0; x < A.length; x++) {
            int u = minDistance(dist, s);
            s[u] = true;
            for (int j = 0; j < A.length; j++) {
                if (!s[j] && dist[u] + A[u][j] < dist[j]) {
                    dist[j] = dist[u] + A[u][j];
                }
            }
        }
        System.out.print("\nThe length of shortest path from "+v[Fnode]+" to "+v[Lnode]+": ");
        System.out.println(dist[Lnode]);
    }

    int minDistance(int dist[], boolean[] s) {
        int min = infiniti, min_index = -1;
        for (int i = 0; i < A.length; i++) {
            if (dist[i] <= min && !s[i]) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        int B[][] = {
            {0, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 0},
            {1, 1, 0, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},};
        G.setData(B);
        G.disp();
        G.BFS(1);
        G.DFS(1);
        G.Dijkstra(1, 5);
    }
}
