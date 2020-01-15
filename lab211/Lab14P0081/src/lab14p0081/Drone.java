/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab14p0081;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Drone extends Bee implements IBee {

    ArrayList<Drone> listDrone = new ArrayList<>();
    private int healthPoint;

    public Drone() {

    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public ArrayList<Drone> getListDrone() {
        return listDrone;
    }

    public void setListDrone(ArrayList<Drone> listDrone) {
        this.listDrone = listDrone;
    }

    public Drone(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void createBeeList() {
        listDrone.clear();
        for (int i = 0; i < 10; i++) {
            listDrone.add(new Drone(100));
            System.out.println("Drone|"+listDrone.get(i).getHealthPoint() + "|alive");
        }
        System.out.println();
    }

    @Override
    public void damage() {
        for (int i = 0; i < 10; i++) {
            int point = super.randomAttack();
            listDrone.get(i).setHealthPoint(listDrone.get(i).getHealthPoint() - point);
            int currentPoint = listDrone.get(i).getHealthPoint();
            if (currentPoint < 0) {
                currentPoint = 0;
            }
            System.out.print("Drone|"+currentPoint + "|");
            if (currentPoint < 50) {
                System.out.println("dead");
            } else {
                System.out.println("alive");
            }
        }
    }
}
