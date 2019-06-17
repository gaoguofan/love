package org.bkn.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bkn.system.service.RedisService;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisSourceConfig {
    
    @Value(value="${redis.host}")
    private String redisHost;
    @Value(value="${redis.port}")
    private Integer redisPort;
    @Value(value="${redis.pwd}")
    private String redisPwd;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(1000);
        jedisPoolConfig.setMinIdle(20);
        jedisPoolConfig.setMaxWaitMillis(10000);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }
    
    @Bean
    public redis.clients.jedis.JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig(), "127.0.0.1", redisPort, 100000);
        return jedisPool;
    }
    
    @Bean(name="redisService")
    public com.bkn.system.service.RedisService redisService(){
        return new RedisService();
    }
    
    
}
