/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ThreadA extends Thread{
    public ThreadA(){
        
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("A "+i);
        }
    }
}
