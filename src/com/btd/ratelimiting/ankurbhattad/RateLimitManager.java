package com.btd.ratelimiting.ankurbhattad;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

// Singleton class to manage rate limit for each user
public final class RateLimitManager {
    
    // singleton instance
    public static final RateLimitManager _instance = new RateLimitManager();
    private ConcurrentHashMap<String, Bucket> rateLimitBuckets = new ConcurrentHashMap<>();
    
    public void provisionRateLimit(String user, int capacity, TimeUnit timeUnit,
            int refillTokenCount, int refillTime) {
        Bucket bucket = new Bucket(user, capacity, timeUnit, refillTokenCount, refillTime);
        bucket.startTokenRefresherThread();
        rateLimitBuckets.put(user, bucket);
    }
   
    public void addRequestForUser(String user) throws RateLimitExceededException {
        Bucket userBucket = rateLimitBuckets.get(user);
        if (userBucket != null) {
            userBucket.executeRequest();
        }
    }    
}
