package com.sbmage.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	

	/**
	 * JedisPool
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		final JedisPool pool = new JedisPool(new JedisPoolConfig(), "14.63.222.114", 16379, 3000, "Die8wl0P");
		Jedis jedis = pool.getResource();
		

        try {
        	
        	
        	logger.info("id1 ::: " + jedis.get("id1"));
            logger.info("id2 ::: " + jedis.get("id2"));
            
            logger.info("jedis.dbSize() ::: " + jedis.dbSize());
            logger.info("jedis.getDB() ::: " + jedis.getDB());
            logger.info("jedis.clientList() ::: " + jedis.clientList());
             
        } catch(Exception e) {
        	e.printStackTrace();
        }
		finally { 
            pool.returnResource(jedis);
        } 
        pool.destroy();
	}

}
