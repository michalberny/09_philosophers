package com.philosophers;

public class Philosophers implements Runnable {
    private Fork leftFork;
    private Fork rightFork;
    private int foodLeft = 10000;

    public Philosophers (Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void doAction (String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" "+action);
        Thread.sleep(200);
    }

    @Override
    public void run(){
        try{
            while (foodLeft > 0) {
                doAction("Food left: "+this.foodLeft+" - Thinking");
                synchronized (leftFork){
                    doAction("Food left: "+this.foodLeft+" - Picked up left fork");
                }
                synchronized (rightFork) {
                    doAction("Food left: "+this.foodLeft+" - Picked up right fork and started eating");
                    doAction("Food left: "+this.foodLeft+" - Put down right fork");
                    this.foodLeft -=1;
                }
                doAction("Food left: "+this.foodLeft+" - Put down left fork and start thinking");


            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }

    }
}
