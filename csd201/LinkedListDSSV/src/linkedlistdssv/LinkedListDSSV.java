/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistdssv;

import java.util.Scanner;

/**
 *
 * @author Admin
 */

//em có một vấn đề là khi ban đầu trong list chỉ có 1 phần tử thì chương trình sẽ không in ra "not found" nếu nhập id không tồn tại và bị lỗi
//hàm search(int x) thầy hướng dẫn bọn em cũng gặp vấn đề này
//nếu trong list có từ 2 phần tử trở lên thì sẽ không bị nữa cho dù sau khi xóa đi chỉ còn 1 phần tử thì cũng không bị lỗi
class Node {

    String id, name, email;
    int age;
    Node next;

    Node() {
    }

    Node(String id, String name, String email, int age, Node next) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.next = next;
    }

    Node(String id, String name, String email, int age) {
        this(id, name, email, age, null);
    }
}

public class LinkedListDSSV {

    Scanner in = new Scanner(System.in);
    Node head, tail;

    LinkedListDSSV() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void addlast(String id, String name, String email, int age) {
        Node q = new Node(id, name, email, age);
        if (isEmpty()) {
            head = q;
            tail = q;
        }
        tail.next = q;
        tail = q;
    }

    void traverse() {
        Node p = head;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "ID", "Name", "Email", "Age");
        while (p != null) {
            System.out.printf("%-15s%-15s%-15s%-15d\n", p.id, p.name, p.email, p.age);
            p = p.next;
        }
    }

    Node search(String x) {
        Node p = head;
        while ((p != null) && (!p.id.equalsIgnoreCase(x))) {
            p = p.next;
        }
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }
    
    void delete(String s) {
        Node p = head, q = null;
        if (p != null && p.id.equalsIgnoreCase(s)) {
            head = p.next;
            return;
        }
        while (p != null && !p.id.equalsIgnoreCase(s)) {
            q = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        q.next = p.next;
    }

    void addStudent() {
        String sID, sName, sEmail;
        int sAge;
        System.out.print("Enter student ID: ");
        sID = in.next();
        System.out.print("Enter student name: ");
        sName = in.next();
        System.out.print("Enter student email: ");
        sEmail = in.next();
        System.out.print("Enter student age: ");
        sAge = in.nextInt();
        addlast(sID, sName, sEmail, sAge);

    }

    void searchStudent() {
        String sID;
        System.out.print("Enter student ID to search: ");
        sID = in.next();
        Node p = search(sID);
        if (p != null) {
            System.out.printf("%-15s%-15s%-15s%-15s\n", "ID", "Name", "Email", "Age");
            System.out.printf("%-15s%-15s%-15s%-15d\n", p.id, p.name, p.email, p.age);
        } else {
            System.err.println("Not found");
        }
    }

    void deleteStudent() {
        String sID;
        System.out.print("Enter student ID to delete: ");
        sID = in.next();
        if (search(sID) != null) {
            delete(sID);
        } else {
            System.err.println("Not found");
        }
    }

    void menu() {
        System.out.println("1. Add a student");
        System.out.println("2. Search a student");
        System.out.println("3. Delete a student");
        System.out.println("4. Print all students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListDSSV L = new LinkedListDSSV();
        while (true) {
            L.menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    L.addStudent();
                    break;
                case 2:
                    L.searchStudent();
                    break;
                case 3:
                    L.deleteStudent();
                    break;
                case 4:
                    L.traverse();
                    break;
                case 5:
                    return;
            }
        }
    }
}
