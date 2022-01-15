package com.btd.ratelimiting.ankurbhattad;

import java.util.concurrent.TimeUnit;

public class TokenRefresherThread extends Thread {
    private TimeUnit timeUnit;
    private int refillTokenCount;
    private int refillTime;
    private Bucket bucket;

    public TokenRefresherThread(TimeUnit timeUnit, int refillTokenCount, int refillTime, Bucket bucket) {
        this.timeUnit = timeUnit;
        this.refillTokenCount = refillTokenCount;
        this.refillTime = refillTime;
        this.bucket = bucket;
    }

    @Override
    public void run() {
        while (true) {
            bucket.addTokens(refillTokenCount);
            try {
                long sleepTimeInMilliSec = timeUnit.toMillis(refillTime);
                System.out.println("Token refreshing thread sleeping for milli seconds: "+sleepTimeInMilliSec);
                Thread.sleep(sleepTimeInMilliSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
