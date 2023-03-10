package com.lhf.web;

import com.lhf.entity.Params;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/cache")
@CacheConfig(cacheNames = "cache") // 默认的缓存key
public class CacheController {
    @GetMapping("/info")
    @Cacheable // 缓存存在方法就不会执行
    public Params info(@RequestParam(name = "id") Long id) {
        System.out.println("info..");
        return new Params();
    }

    @CacheEvict(key = "#id") // 删除key为2的缓存
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
        System.out.println("update..");
        return "";
    }

    @CachePut(key = "#id") // 每次都会执行，并更新缓存
    @GetMapping("/update")
    public Params update(@RequestParam(name = "id") Long id){
        System.out.println("update..");
        Params params = new Params();
        params.setCid(String.valueOf(new Random().nextInt()));
        return params;
    }
}
