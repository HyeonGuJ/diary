package com.hyeonguj.diary.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class SampleRestController {

    @GetMapping("/welcome")
    fun sampleController(): String {
        return "hello! - From BackEnd";
    }
}