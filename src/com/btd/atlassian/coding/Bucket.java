package com.btd.atlassian.coding;


import java.util.concurrent.TimeUnit;

public class Bucket {
    private int capacity;
    private TimeUnit timeunit;
    private int timeInterval;
    private int refreshTokenCount;
    private int availableToken;
    private TokenRefreshingThread refresherThread;

    public Bucket (int capacity, TimeUnit timeunit, int timeInterval, int refreshTokenCount) {
        this.capacity = capacity;
        this.timeunit = timeunit;
        this.timeInterval = timeInterval;
        this.refreshTokenCount = refreshTokenCount;
    }

    public void provisionRateLimit() {
        refresherThread = new TokenRefreshingThread(this, timeunit, timeInterval);
        refresherThread.start();
    }

    public synchronized void addTokens () {
        int existingNoOfTokens = availableToken;
        availableToken = Math.min(availableToken + refreshTokenCount, capacity);
        System.out.println((availableToken - existingNoOfTokens)+" Tokens added successfully to bucket: "+this);
    }

    public synchronized boolean executeRequest() {
        if (this.availableToken > 0) {
            System.out.println("Request id forwarded. No of tokens left is: "+(availableToken-1));
            availableToken--;
            return true;
        } else {
            System.out.println("Request is denied as limit exceeded");
            return false;
        }
    }
}
