package com.hyeonguj.diary.sample

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SampleRestController(private var redisTemplate: RedisTemplate<String,Any>) {


    @GetMapping(value = ["/welcome"])
    fun sampleController(): String {
        return "hello! - From BackEnd";
    }

    @GetMapping(value = ["/redis/{key}"])
    fun get(@PathVariable key: String): String {
        val opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key).toString();
    }

    @GetMapping(value = ["/redis/{key}/{value}"])
    fun set(@PathVariable key: String, @PathVariable value: String): String {

        val opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value)
        return opsForValue.get(key).toString()

    }
}