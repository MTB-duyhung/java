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
public class Worker extends Bee implements IBee {

    ArrayList<Worker> listWorker = new ArrayList<>();
    private int healthPoint=100;

    public Worker() {

    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public ArrayList<Worker> getListWorker() {
        return listWorker;
    }

    public void setListWorker(ArrayList<Worker> listWorker) {
        this.listWorker = listWorker;
    }

    public Worker(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void createBeeList() {
        listWorker.clear();
        for (int i = 0; i < 10; i++) {
            listWorker.add(new Worker(healthPoint));
            System.out.println("Worker|"+listWorker.get(i).getHealthPoint() + "|alive");
        }
        System.out.println(""+healthPoint);
    }

    @Override
    public void damage() {
        for (int i = 0; i < 10; i++) {
            int point = super.randomAttack();
            System.out.println("Worker|"+listWorker.get(i).getHealthPoint() + "|alive");
//            listWorker.get(i).setHealthPoint(listWorker.get(i).getHealthPoint() - point);
//            int currentPoint = listWorker.get(i).getHealthPoint();
//            if (currentPoint < 0) {
//                currentPoint = 0;
//            }
//            System.out.print("Worker|"+currentPoint + "|");
//            if (currentPoint < 70) {
//                System.out.println("dead");
//            } else {
//                System.out.println("alive");
//            }
        }
    }
}
