package com.brijesh.tasks;

public class Task implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("I am the task which needs to be completed");
    }
}
