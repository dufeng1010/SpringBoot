package com.dufeng.goal.util;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    
    private CountDownLatch latch;

    public Receiver(CountDownLatch latch) {
        super();
        this.latch = latch;
    }
    
    public void receiveMessage(String message) {
       System.out.println("Received < " + message + ">");
       latch.countDown();
    }
}
