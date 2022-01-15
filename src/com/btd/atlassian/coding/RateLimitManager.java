package com.btd.atlassian.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RateLimitManager {
    private Map<Integer, Bucket> userBuckets = new HashMap<>();

    private Bucket provisionRateLimitForUser(int x) {
        Bucket bucket =  new Bucket(x, TimeUnit.SECONDS, 60, x);
        bucket.provisionRateLimit();
        return  bucket;
    }

    boolean isRequestAllowed(int customerId) {
        int x = 10;
        Bucket userBucket = userBuckets.get(customerId);
        if (userBucket == null) {
            userBucket = provisionRateLimitForUser(x);
        }
        userBuckets.put(customerId, userBucket);
        return userBucket.executeRequest();
    }
}
