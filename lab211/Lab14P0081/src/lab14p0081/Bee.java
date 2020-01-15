/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab14p0081;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Bee {

    public int randomAttack() {
        Random ran = new Random();
        int min = 0;
        int max = 80;
        return ran.nextInt((max - min) + 1) + min;
    }
}
