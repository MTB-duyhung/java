/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadProperties;

/**
 *
 * @author Admin
 */
public class ThreadProperties extends Thread{
    public ThreadProperties(String threadName){
        super(threadName);
        this.start();
    }
    public static void showProperties(Thread t){
        System.out.println("I'm the "+t.getName()+" thread");
        System.out.println("--My ID: "+t.getId());
        System.out.println("--My name: "+t.getName());
        System.out.println("--My priority: "+t.getPriority());
        System.out.println("--My state: "+t.getState());
        System.out.println("--I'm a deamon: "+t.isDaemon());
        System.out.println("--I'm alive: "+t.isAlive());
    }
    public void run(){
        showProperties(this);
    }
    public static void main(String args[]){
        System.out.println("Thread count: "+Thread.activeCount());
        Thread t=Thread.currentThread();
        showProperties(t);
        ThreadProperties t1=new ThreadProperties("Son1");
        ThreadProperties t2=new ThreadProperties("son2");
        System.out.println("Thread count: "+Thread.activeCount());
    }
}
