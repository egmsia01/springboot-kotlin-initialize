package com.springkt.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author Ge Mingjia
 * @date 2023/10/21
 */
@Configuration
class CorsConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        // 覆盖所有请求
        registry.addMapping("/**")
            // 允许发送 Cookie
            .allowCredentials(true)
            // 放行哪些域名（必须用 patterns，否则 * 会和 allowCredentials 冲突）
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .exposedHeaders("*")
    }
}