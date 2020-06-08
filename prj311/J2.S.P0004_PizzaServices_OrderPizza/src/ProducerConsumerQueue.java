
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ProducerConsumerQueue {

    ArrayList<String> foodString = new ArrayList<>();
    Queue<String> foodTray=new LinkedList<>();
    int slg=5;
    public ProducerConsumerQueue() {
        foodString.add("Deluxe Pizza");
        foodString.add("SinglePizza");
        foodString.add("American Pizza");
        foodString.add("Double Pizza");
    }
    synchronized void add() throws InterruptedException{
        while (foodTray.size()>=slg) {
            System.out.println("Foodtray chain is full");
            wait();
        }
        int i=(int)Math.round(Math.random()*(foodString.size()-1));
        String pizza=foodString.get(i);
        foodTray.add(pizza);
        notify();
    }
    synchronized void get() throws InterruptedException{
        while (foodTray.isEmpty()) {
            System.out.println("Waiting for new pizza");
            wait();
        }
        String val = foodTray.remove();
        System.out.println("Pizza delivered: "+val);
        notify();
    }
}
