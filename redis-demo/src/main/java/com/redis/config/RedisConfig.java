package com.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author junlin_huang
 * @create 2020-08-19 下午11:20
 **/

@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        return jedis;
    }
}