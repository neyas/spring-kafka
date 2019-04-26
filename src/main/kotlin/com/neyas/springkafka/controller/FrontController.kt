package com.neyas.springkafka.controller

import com.neyas.springkafka.service.Producer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/kafka")
class FrontController {

    private val logger: Logger = LoggerFactory.getLogger(FrontController::class.java)

    @Autowired
    lateinit var producer: Producer

    @PostMapping("/publish")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String) {
        logger.info("Starting the sending message")
        this.producer.sendMessage(message)
        logger.info("Sent the message")
    }

}