package com.springkt.demo.model.entity

import java.time.LocalDateTime

/**
 * @author Ge Mingjia
 * @date 2023/10/21
 */
data class User(
    val id: Int,
    val userAccount: String,
    val userPassword: String,
    val userName: String?,
    val userAvatar: String?,
    val userProfile: String?,
    val userRole: String,
    val createTime: LocalDateTime,
    val updateTime: LocalDateTime,
    val isDelete: Boolean
)