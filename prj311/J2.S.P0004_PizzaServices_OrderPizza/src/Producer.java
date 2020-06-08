
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Producer extends Thread{
    ProducerConsumerQueue foodQueue;
    
    public Producer(ProducerConsumerQueue foodQueue){
        this.foodQueue=foodQueue;
    }
    public void run(){
        while (true) {
            try {
                foodQueue.add();
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
