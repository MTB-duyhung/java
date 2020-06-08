import java.util.Random;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Store {

    int maxN = 5;
    Stack<Integer> a = new Stack<>();
    int min = 1;
    int max = 100;
    Random r = new Random();

    public Store() {
        this.a = new Stack<>();
    }

    public boolean available() {
        return a.size() == maxN;
    }
    synchronized void add() throws InterruptedException {
        if (available()) {
            notify();
            wait();
        }
        int x = r.nextInt(max - min + 1) + min;
        a.push(x);
        System.out.println("Adding new whole number: " + x);
        
    }

    synchronized void delete() throws InterruptedException {
        if (!available()) {
            notify();
            wait();
        }
        int numDel = a.pop();
        System.out.println("Deleteing whole number: " + numDel);
        numDel = a.pop();
        System.out.println("Deleteing whole number: " + numDel);
        numDel = a.pop();
        System.out.println("Deleteing whole number: " + numDel);
    }
}
