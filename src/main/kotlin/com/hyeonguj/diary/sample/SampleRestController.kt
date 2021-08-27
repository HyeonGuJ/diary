package com.hyeonguj.diary.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleRestController {

    @GetMapping
    fun sampleController() : String {
        return "hello";
    }
}