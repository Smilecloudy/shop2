package com.it.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis工具类
 */
public final class JedisUtil {

    private static JedisPool jedisPool;

    static {
        try {
            InputStream inputStream = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            int maxTotal = Integer.parseInt(properties.getProperty("redis.maxTotal"));
            int maxWaitMillis = Integer.parseInt(properties.getProperty("redis.maxWaitMillis"));
            String host = properties.getProperty("redis.host");
            int port = Integer.parseInt(properties.getProperty("redis.port"));

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            jedisPool = new JedisPool(jedisPoolConfig, host, port);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        System.out.println(jedis);
        jedis.close();
    }
}
