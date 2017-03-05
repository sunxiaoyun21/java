package com.sxy.service;

import com.sxy.pojo.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
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

  @Autowired
  private RedisTemplate redisTemplate;


    public  void saveRedis(){
        User user=new User(103,"张三",89.5F);
        Schema<User> userSchema= RuntimeSchema.getSchema(User.class);
       //user对象转换为二进制数组
        byte[] userByte=
                ProtobufIOUtil.toByteArray(user,userSchema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

        redisTemplate.opsForValue().set("user:103".getBytes(),userByte);
    }

    /*
    * 进行反序列化
    * */
    public String getFromRedis() {
        Schema<User> userSchema= RuntimeSchema.getSchema(User.class);
        User user=new User();
        byte[] userByte= (byte[]) redisTemplate.opsForValue().get("user:103".getBytes());
        ProtobufIOUtil.mergeFrom(userByte,user,userSchema);
        System.out.println(user);
        return null;

       }



  /*  @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
    }

    public  void saveRedis(){
        User user=new User(101,"tom",89.5F);
        redisTemplate.opsForValue().set("name:1",user);

        *//*BoundValueOperations operations=redisTemplate.boundValueOps("book:name:1");
        operations.set("redis");*//*
        //redisTemplate.opsForList().leftPush("book","sql","java");
      *//*  redisTemplate.opsForValue().set("book:name:2","head first java");*//*
    }

    public String getFromRedis(){
        User user= (User) redisTemplate.opsForValue().get("name:1");
        System.out.println(user);
        return null;
    }

*/












  /*  public  void saveRedis(){
        Jedis jedis=jedisPool.getResource();
        jedis.set("name","jack");
        jedis.close();

    }*/
}
