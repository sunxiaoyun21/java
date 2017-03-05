import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

        @Test
        public void stringSet(){
            Jedis jedis=new Jedis("119.29.80.89",6379,5000);
            jedis.set("name","lisi");
            jedis.close();
        }

        @Test
        public void StringGet(){
            Jedis jedis=new Jedis("119.29.80.89",6379,5000);
            String name=jedis.get("name");
            jedis.close();
            Assert.assertEquals("lisi",name);
        }

        @Test
        public void setPool(){
            JedisPoolConfig poolConfig=new JedisPoolConfig();
            poolConfig.setMaxWaitMillis(5000);
            poolConfig.setMaxTotal(200);
            poolConfig.setMinIdle(20);
            JedisPool jedisPool=new JedisPool(poolConfig,"119.29.80.89",6379);//创建连接池
           Jedis jedis= jedisPool.getResource();//获取链接资源
             jedis.lpush("names","shangzan","lisi","jack");
             jedis.close();
             jedisPool.destroy();

        }
        @Test
        public  void testList(){
            Jedis jedis=new Jedis("119.29.80.89",6379);
            List<String> names=jedis.lrange("names",0,-1);
            for(String name:names){
                System.out.println(name);
            }
            jedis.close();

           /* String name=jedis.lpop("names");
            jedis.close();
            System.out.println(name);*/



        }

        @Test
        public  void testHash(){
            Jedis jedis=new Jedis("119.29.80.89",6379);
          /*  Map<String,String> map=new HashMap<>();
            map.put("id","101");
            map.put("age","13");
            map.put("name","rose");
            jedis.hmset("name:1",map);*/
          String name=jedis.hget("name:1","name");
            System.out.println(name);
            jedis.close();

        }
}
