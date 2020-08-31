package com.redis.distributelock;

import com.redis.BasicTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author junlin_huang
 * @create 2020-08-20 上午2:31
 **/

public class DistributeLockTest extends BasicTest {

    @Autowired
    private DistributeLock distributeLock;

    @Test
    public void testDistributeLock() {
        String identify = distributeLock.acquireLock("key", 10000);
        distributeLock.releaseLock("key", identify);
    }
}