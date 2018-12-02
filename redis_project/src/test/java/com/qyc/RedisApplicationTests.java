package com.qyc;

import com.qyc.Config.RedisConfig;
import com.qyc.Utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
	@Autowired
	RedisUtil redisUtil;
	@Autowired
	RedisConfig jedisConfig;
	@Test
	public void simpleTest() {
		Jedis jedis = new Jedis("127.0.0.1", 6379, 10000);
		System.out.println("Connection to server sucessfully");
		//2. set the data in redis string
		String theName = jedis.get("age");
		System.out.println("age"+theName);
		//jedis.set("username", "Roxin");
		//3. Get the stored data and print it
		//System.out.println("Stored string in redis:: "+ jedis.get("username"));
		//4. Close the Redis connection;
		jedis.close();
	}


	@Test
	public void test() {
		//@SuppressWarnings("resource")
		//ApplicationContext context=new ClassPathXmlApplicationContext("classpath:redis-dev.xml");
		//RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");
		//System.out.println(redisUtil.lRemove("15532002728",1,2));
		//System.out.println(redisUtil.lGet("15532002728",0,-1));
		//System.out.println(redisUtil.lGetListSize("15532002728"));
		//System.out.println(redisUtil.lGetIndex("15532002728",1));
		System.out.println("age: "+redisUtil.get("age"));
	}

}
