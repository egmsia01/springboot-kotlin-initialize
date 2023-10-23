package com.springkt.demo.controller

import com.springkt.demo.common.BaseResponse
import org.springframework.web.bind.annotation.*

/**
 * @author Ge Mingjia
 * @date 2023/10/21
 */
@RestController
class DemoController {
    @PostMapping("/hello")
    fun helloWorld(): BaseResponse<String> {
        return BaseResponse.success("good")
    }

    @GetMapping("/user/{name}")
    fun getName(@PathVariable name: String): BaseResponse<String> {
        return BaseResponse.success("Hello, $name!")
    }
}