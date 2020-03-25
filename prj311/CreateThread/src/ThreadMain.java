/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ThreadMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB obj = new ThreadB();
        Thread t2 = new Thread(obj);
        t1.start();
        t2.start();
    }

}
