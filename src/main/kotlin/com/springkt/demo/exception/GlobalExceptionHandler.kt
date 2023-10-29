package com.springkt.demo.exception

import com.springkt.demo.common.BaseResponse
import com.springkt.demo.common.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 全局异常处理器
 *
 * @author Ge Mingjia
 * @date 2023/10/21
 */
@RestControllerAdvice
class GlobalExceptionHandler {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BusinessException::class)
    fun businessExceptionHandler(e: BusinessException): BaseResponse<*> {
        log.error("businessException: ${e.message}", e)
        return BaseResponse.error<Any>(e.code, e.message ?: "")
    }

    @ExceptionHandler(RuntimeException::class)
    fun runtimeExceptionHandler(e: RuntimeException): BaseResponse<*> {
        log.error("runtimeException", e)
        return BaseResponse.error<Any>(ErrorCode.SYSTEM_ERROR, e.message ?: "")
    }
}

