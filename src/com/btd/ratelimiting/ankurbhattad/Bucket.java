package com.btd.ratelimiting.ankurbhattad;

import java.util.concurrent.TimeUnit;

public class Bucket {
    private String userId;
    private int capacity;
    private int availableTokens;
    private TimeUnit timeUnit;
    private int refillTokenCount;
    private int refillTime;
    private TokenRefresherThread refresherThread;


    public Bucket(String userId, int capacity, TimeUnit timeUnit,
                  int refillTokenCount, int refillTime) {
        this.userId = userId;
        this.capacity = capacity;
        this.timeUnit = timeUnit;
        this.refillTokenCount = refillTokenCount;
        this.refillTime = refillTime;
        refresherThread = new TokenRefresherThread(timeUnit, refillTokenCount, refillTime, this);
    }
    
    public void startTokenRefresherThread () {
        refresherThread.start();
    }
    
    public synchronized void executeRequest() throws RateLimitExceededException {
        if (availableTokens <= 0) {
            throw new RateLimitExceededException();
        }
        availableTokens--;
        System.out.println("Request forwarded. Remaining Tokens: "+availableTokens);
    }

    public synchronized void addTokens(int n) {
        int prevAvailableTokens = availableTokens;
        availableTokens = Math.min(capacity, availableTokens+n);
        System.out.println((availableTokens-prevAvailableTokens)+" Tokens added successfully");
    }
}
