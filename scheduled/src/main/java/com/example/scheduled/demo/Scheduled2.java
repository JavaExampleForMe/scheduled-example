package com.example.scheduled.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduled2 {

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {

        System.out.println(
                "Scheduled2 - " + this.toString() + " Thread="  + Thread.currentThread().getName() + " Thread="  + Thread.currentThread().getId() + " " + System.currentTimeMillis()/1000);
    }
}
