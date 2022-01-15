package com.btd.ratelimiting.ankurbhattad;

import java.util.concurrent.TimeUnit;

public class RateLimitTest {
    
    public static void main(String args[]) throws InterruptedException {
        RateLimitManager._instance.provisionRateLimit("Ankur", 10, TimeUnit.SECONDS, 10, 60);
        Thread.sleep(5000);
        for (int i=1; i<=5; i++) {
            try {
                RateLimitManager._instance.addRequestForUser("Ankur");
            } catch (RateLimitExceededException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Thread.sleep(60000);
        for (int i=1; i<=15; i++) {
            try {
                RateLimitManager._instance.addRequestForUser("Ankur");
            } catch (RateLimitExceededException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
