package com.philosophers;

public class Main {

    public static void main(String[] args) {
	    Philosophers philosophers[] = new Philosophers[10];
	    Fork fork[] = new Fork[10];

	    for (int i = 0; i < philosophers.length; i++){
	        fork[i] = new Fork(i+1);
        }

	    for (int i = 0; i < philosophers.length; i++){
	        Fork leftFork = fork[i];
	        Fork rightFork = fork[(i + 1)% fork.length];

	        if (i == philosophers.length - 1){
	            philosophers[i] = new Philosophers(leftFork,rightFork);
            }
	        else{
	            philosophers[i] = new Philosophers(rightFork, leftFork);
            }

	        Thread t = new Thread(philosophers[i] ," Philosopher " +(i+1));
	        t.start();
        }

    }
}
