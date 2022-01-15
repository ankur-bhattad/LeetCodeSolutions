package com.btd.atlassian.coding;

public class RateLimitTest {
    public static void main(String args[]) throws InterruptedException {
        RateLimitManager rateLimitManager = new RateLimitManager();
        rateLimitManager.isRequestAllowed(1);
        Thread.sleep(10000);
        for (int i=1; i<=11; i++) {
            rateLimitManager.isRequestAllowed(1);
        }
    }
}
