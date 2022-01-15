package com.btd.atlassian.coding;

import java.util.concurrent.TimeUnit;

public class TokenRefreshingThread extends Thread {

    private Bucket bucket;
    private TimeUnit timeunit;
    private int timeInterval;

    public TokenRefreshingThread (Bucket bucket, TimeUnit timeunit, int timeInterval) {
        this.bucket = bucket;
        this.timeunit = timeunit;
        this.timeInterval = timeInterval;
    }

    @Override
    public void run() {
        while (true) {
            bucket.addTokens();
            try {
                long sleepTimeInMilliSec = timeunit.toMillis(timeInterval);
                System.out.println("Token Refreshing thread sleeping for milli Secs: "+sleepTimeInMilliSec);
                Thread.sleep(sleepTimeInMilliSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
