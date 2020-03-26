package com.example.scheduled.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Scheduled1 {

    Semaphore sem = new Semaphore(3);

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() throws InterruptedException {
        boolean semAnswer = false;
        try
        {
            // acquiring the lock
            semAnswer = sem.tryAcquire();
            if (semAnswer) {
                System.out.println(
                        "Scheduled1 - " +  sem.availablePermits() + " " +  this.toString() + " Thread=" + Thread.currentThread().getName() + " Thread=" + Thread.currentThread().getId() + " " + System.currentTimeMillis() / 1000);
                Thread.sleep(20000);
            }else
                System.out.println("execution skipped!");
        } finally {
            // Release the permit.
            System.out.println(" Thread="  + Thread.currentThread().getId() + " releases the permit.");
            if (semAnswer)
                sem.release();
        }
    }

}
