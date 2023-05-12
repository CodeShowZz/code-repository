package com.redis.distributelock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * 分布式锁的实现
 * @author huangjunlin
 * @date 2020/8/10.
 */
@Component
public class DistributeLock {

    @Autowired
    private Jedis jedis;

    public String acquireLock(String lockName) {
        return acquireLock(lockName, 10000);
    }

    public String acquireLock(String lockName, long acquireTimeout) {
        long end = System.currentTimeMillis() + acquireTimeout;
        String lockKey = "lock:" + lockName;
        String identify = UUID.randomUUID().toString();
        while (System.currentTimeMillis() < end) {
            if (jedis.setnx(lockKey, identify) == 1) {
                return identify;
            }
        }
        return null;
    }

    public String acquireLockWithTimeout(String lockName, long acquireTimeout, long lockTimeout) {
        long end = System.currentTimeMillis() + acquireTimeout;
        String lockKey = "lock:" + lockName;
        String identify = UUID.randomUUID().toString();
        while (System.currentTimeMillis() < end) {
            if (jedis.setnx(lockKey, identify) == 1) {
                jedis.expire(lockKey, (int) lockTimeout);
                return identify;
            }
            if (jedis.ttl(lockKey) == -1) {
                jedis.expire(lockKey, (int) lockTimeout);
            }
        }
        return null;
    }

    public boolean releaseLock(String lockName, String identifier) {
        while (true) {
            jedis.watch(lockName);
            String lockKey = "lock:" + lockName;
            if (jedis.get(lockKey).equals(identifier)) {
                Transaction trans = jedis.multi();
                trans.del(lockKey);
                List<Object> results = trans.exec();
                if (results == null) {
                    continue;
                }
                return true;
            }
            jedis.unwatch();
            break;
        }
        return false;
    }
}
