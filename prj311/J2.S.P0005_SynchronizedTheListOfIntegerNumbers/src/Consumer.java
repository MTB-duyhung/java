
import java.util.Random;
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
public class Consumer extends Thread {

    Store s = new Store();

    public Consumer(Store s) {
        this.s = s;
    }

    public void run() {
        while (true) {
            try {
                s.delete();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
