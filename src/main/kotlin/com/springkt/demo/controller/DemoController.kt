package com.springkt.demo.controller

import org.springframework.web.bind.annotation.*

/**
 * @author Ge Mingjia
 * @date 2023/10/21
 */
@RestController
class DemoController {
    @PostMapping("/hello")
    fun helloWorld(): String {
        return "Hello World!"
    }

    @GetMapping("/user/{name}")
    fun getName(@PathVariable name: String): String {
        return "Hello, $name!"
    }
}