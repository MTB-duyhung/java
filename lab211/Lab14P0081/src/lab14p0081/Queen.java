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
public class Queen extends Bee implements IBee {

    ArrayList<Queen> listQueen = new ArrayList<>();
    private int healthPoint;

    public Queen() {

    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public ArrayList<Queen> getListQueen() {
        return listQueen;
    }

    public void setListQueen(ArrayList<Queen> listQueen) {
        this.listQueen = listQueen;
    }

    public Queen(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void createBeeList() {
        listQueen.clear();
        for (int i = 0; i < 10; i++) {
            listQueen.add(new Queen(100));
            System.out.println("Queen|"+listQueen.get(i).getHealthPoint() + "|alive");
        }
        System.out.println();
    }

    @Override
    public void damage() {
        for (int i = 0; i < 10; i++) {
            int point = super.randomAttack();
            listQueen.get(i).setHealthPoint(listQueen.get(i).getHealthPoint() - point);
            int currentPoint = listQueen.get(i).getHealthPoint();
            if (currentPoint < 0) {
                currentPoint = 0;
            }
            System.out.print("Queen|"+currentPoint + "|");
            if (currentPoint < 20) {
                System.out.println("dead");
            } else {
                System.out.println("alive");
            }
        }
    }
}
