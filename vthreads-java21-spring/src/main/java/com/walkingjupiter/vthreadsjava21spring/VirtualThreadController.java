package com.walkingjupiter.vthreadsjava21spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualThreadController {

    @GetMapping("/data")
    public String getData() {
        try {
            System.out.println("Running on thread: " +  Thread.currentThread().getName());
            // Simulate slow external service
            Thread.sleep(2000);
            return "Data from slow service".toUpperCase();
        } catch (InterruptedException e) {
            // Handle potential interruption
            return "Operation Interrupted";
        }
    }
}
