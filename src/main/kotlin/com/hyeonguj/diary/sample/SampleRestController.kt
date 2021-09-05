package com.hyeonguj.diary.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SampleRestController {

    @GetMapping(value=["/welcome"])
    fun sampleController(): String {
        return "hello! - From BackEnd";
    }
}