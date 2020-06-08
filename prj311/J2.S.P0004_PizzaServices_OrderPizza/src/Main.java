/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        ProducerConsumerQueue q = new ProducerConsumerQueue();
        Producer p = new Producer(q);
        p.start();
        Consumer c = new Consumer(q);
        c.start();
    }

}
