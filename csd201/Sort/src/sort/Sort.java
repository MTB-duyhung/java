/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Sort {

    int A[];
    int n;
    Scanner in = new Scanner(System.in);

    Sort() {
        n = 0;
    }

    Sort(int n) {
        this.n = n;
        A = new int[n];
    }

    void input() {
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            A[i] = rd.nextInt(10);
        }
    }

    void output() {
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + "  ");
        }
    }

    void swap(int[] A, int i, int k) {
        int tmp = A[i];
        A[i] = A[k];
        A[k] = tmp;
    }

    void selectionSort() {
        int k, min;
        for (int i = 0; i < n - 1; i++) {
            min = A[i];
            k = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    k = j;
                }
            }
            if (k != i) {
                swap(A, i, k);
            }
        }
    }

    void insertSort() {
        int tmp, j;
        for (int i = 0; i < n; i++) {
            tmp = A[i];
            j = i;
            while (j > 0 && tmp < A[j - 1]) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tmp;
        }
    }

    void bubbleSort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    void quickSort(int l, int r) {
        if (l < r) {
            int up = l;
            int down = r;
            int pivot = A[(l + r) / 2];
            do {
                while (A[up] < pivot) {
                    up++;
                }
                while (A[down] > pivot) {
                    down--;
                }
                if (up <= down) {
                    swap(A, up, down);
                    up++;
                    down--;
                }
            } while (up <= down);
            quickSort(l, down);
            quickSort(up, r);
        }
    }

    void merge(int p, int q, int r) {
        if (!(p <= q) && (q <= r)) {
            return;
        }
        int n, i, j, k, x;
        n = r - p + 1;
        int[] B = new int[n];
        i = p;
        j = q + 1;
        k = 0;
        while (i <= q && j <= r) {
            if (A[i] < A[j]) {
                B[k++] = A[i++];
            } else {
                B[k++] = A[j++];
            }
        }
        while (i <= q) {
            B[k++] = A[i++];
        }
        while (j <= r) {
            B[k++] = A[j++];
        }
        k = 0;
        for (i = p; i <= r; i++) {
            A[i] = B[k++];
        }

    }

    void mergeSort(int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(p, q);
        mergeSort(q + 1, r);
        merge(p, q, r);
    }

    void heapSort() {
        int i, s, f;
        int x;
        for (i = 1; i < n; i++) {
            x = A[i];
            s = i;
            while (s > 0 && x > A[(s - 1) / 2]) {
                A[s] = A[(s - 1) / 2];
                s = (s - 1) / 2;
            };
            A[s] = x;
        }
        for (i = n - 1; i > 0; i--) {
            x = A[i];
            A[i] = A[0];
            f = 0;
            s = 2 * f + 1;
            if (s + 1 < i && A[s] < A[s + 1]) {
                s = s + 1;
            }
            while (s < i && x < A[s]) {
                A[f] = A[s];
                f = s;
                s = 2 * f + 1;
                if (s + 1 < i && A[s] < A[s + 1]) {
                    s = s + 1;
                }
            };
            A[f] = x;
        }
    }

    public static void main(String[] args) {
        Sort s = new Sort(10000);
        System.out.println(s.n + "pt");
        long begin, end, duration;
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.selectionSort();
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for selection sort: " + duration);
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.insertSort();
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for insert sort: " + duration);
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.bubbleSort();
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for bubble sort: " + duration);
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.quickSort(0, s.n - 1);
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for quick sort: " + duration);
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.mergeSort(0, s.n - 1);
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for merge sort: " + duration);
        s.input();
//        System.out.println("Array: ");
//        s.output();
        begin = System.currentTimeMillis();
        s.heapSort();
        end = System.currentTimeMillis();
        duration = end - begin;
//        System.out.println("\nArray after sorting: ");
//        s.output();
        System.out.println("\nTime for heap sort: " + duration);
    }

}
