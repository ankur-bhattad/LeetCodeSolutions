package com.btd.ratelimiting.ankurbhattad;

public class RateLimitExceededException extends RuntimeException {

    public RateLimitExceededException() {
        super("RateLimitExceeded");
    }
}
