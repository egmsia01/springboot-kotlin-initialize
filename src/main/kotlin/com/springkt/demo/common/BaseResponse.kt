package com.springkt.demo.common

import org.springframework.http.HttpStatus

/**
 * 通用返回类
 *
 * @param <T>
 * @author miku
 */
data class BaseResponse<T>(
    val code: Int,
    val data: T?,
    val message: String? = null
) {
    companion object {
        fun <T> success(data: T?) = BaseResponse(HttpStatus.OK.value(), data)

        fun <T> error(errorCode: ErrorCode) = BaseResponse(errorCode.code, null, errorCode.message)

        fun <T> error(errorCode: ErrorCode, message: String) = BaseResponse(errorCode.code, null, message)

        fun <T> error(errorCode: Int, message: String) = BaseResponse(errorCode, null, message)
    }
}
