package com.alphaomega.demo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RedisTemplate redisTemplate;
	


    @Test
    public void test() throws Exception {
    	log.info("Start...");
    	
        stringRedisTemplate.opsForValue().set("aaa", "111");
        log.info(stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
    
    @Test
    public void testObj() throws Exception {
        
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        boolean neox=redisTemplate.hasKey("com.neox");
        if(neox){
            System.out.println("neox is true");
        }else{
            System.out.println("neox is false");
        }
   
    }
    
}
