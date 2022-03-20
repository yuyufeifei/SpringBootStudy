package com.gzh.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {

        //操作不同的数据类型
        redisTemplate.opsForValue();
        redisTemplate.opsForList();
        redisTemplate.opsForSet();
        redisTemplate.opsForHash();
        redisTemplate.opsForZSet();
        redisTemplate.opsForGeo();
        redisTemplate.opsForHyperLogLog();

        //获取redis的连接对象
        RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
        connection.flushDb();
        connection.flushAll();

    }

}
