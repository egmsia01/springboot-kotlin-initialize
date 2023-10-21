package com.springkt.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import java.net.InetAddress

@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
    val application = runApplication<KotlinApplication>(*args)
    val env: Environment = application.environment

    println(
    """
    |----------------------------------------------------------
    |   Application '${env.getProperty("spring.application.name")}' is running! Access URLs:
    |   Local:     http://localhost:${env.getProperty("server.port")}
    |   External:  http://${InetAddress.getLocalHost().hostAddress}:${env.getProperty("server.port")}
    |   Doc:       http://${InetAddress.getLocalHost().hostAddress}:${env.getProperty("server.port")}/doc.html#/home
    |----------------------------------------------------------
    """
    )

}
