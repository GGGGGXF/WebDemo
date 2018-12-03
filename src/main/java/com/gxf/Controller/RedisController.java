package com.gxf.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("set/{key}/{value}")
    @ApiOperation(value = "设置缓存")
    public String set(@PathVariable("key") String key,@PathVariable("value") String value) {
        //注意这里的key不能为null spring内部有检测
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }

    @GetMapping("get/{key}")
    @ApiOperation(value = "根据key获取缓存")
    public String get(@PathVariable("key") String key) {
        return "bigkey=" + key + ",bigvalue=" + redisTemplate.opsForValue().get(key);
    }
}
