package com.springkt.demo.exception

import com.springkt.demo.common.ErrorCode

/**
 * 自定义异常类
 *
 * @author Ge Mingjia
 * @date 2023/10/21
 */
class BusinessException(val code: Int, message: String) : RuntimeException(message) {

    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message)

    constructor(errorCode: ErrorCode, message: String) : this(errorCode.code, message)
}

