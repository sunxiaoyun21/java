package com.sxy.service;

import com.sxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;




/**
 * Created by Administrator on 2017/3/5.
 */
@Service
public class UserService {



  private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
    }

    public  void saveRedis(){
        User user=new User(101,"tom",89.5F);
        redisTemplate.opsForValue().set("name:1",user);





        /*BoundValueOperations operations=redisTemplate.boundValueOps("book:name:1");
        operations.set("redis");*/
        //redisTemplate.opsForList().leftPush("book","sql","java");
      /*  redisTemplate.opsForValue().set("book:name:2","head first java");*/
    }

    public String getFromRedis(){
        User user= (User) redisTemplate.opsForValue().get("name:1");
        System.out.println(user);
        return null;
    }














  /*  public  void saveRedis(){
        Jedis jedis=jedisPool.getResource();
        jedis.set("name","jack");
        jedis.close();

    }*/
}
