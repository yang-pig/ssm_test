package com.ssmtest.cache;




import com.ssmtest.BaseTest;
import com.ssmtest.util.RedisUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;





public class TestRedis extends BaseTest{

    @Autowired
    private RedisUtil redisUtil;

    @Ignore
    @Test
    public void testRedisString() throws  Exception {

        redisUtil.set("name", "王赛超");
        redisUtil.set("age", 24);
        redisUtil.set("address", "河北邯郸");

        System.out.println(redisUtil.set("address", "河北邯郸", 50));

        System.out.println(redisUtil.get("age"));

    }





}