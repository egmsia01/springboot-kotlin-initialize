package com.springkt.demo.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

/**
 * 请求日志
 *
 * @author Ge Mingjia
 * @date 2023/10/21
 */
@Aspect
@Component
class LogInterceptor {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Around("execution(* com.springkt.demo.controller.*.*(..))")
    fun doInterceptor(point: ProceedingJoinPoint): Any? {
        val stopWatch = StopWatch()
        stopWatch.start()

        val requestAttributes = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
        val httpServletRequest = requestAttributes.request

        val requestId = UUID.randomUUID().toString()
        val url = httpServletRequest.requestURI
        val args = point.args
        val reqParam = args?.joinToString(", ") { it.toString() } ?: "null"

        logger.info(
            "request start, id => {}, path => {}, ip => {}, params => {}",
            requestId,
            url,
            httpServletRequest.remoteHost,
            reqParam
        )

        val result: Any = try {
            point.proceed()
        } catch (e: Throwable) {
            logger.error("An error occurred while processing the request: $e")
            throw e
        } finally {
            stopWatch.stop()
            val totalTimeMillis = stopWatch.totalTimeMillis
            logger.info("request end, id => {}, cost => {}ms", requestId, totalTimeMillis)
        }

        return result
    }
}