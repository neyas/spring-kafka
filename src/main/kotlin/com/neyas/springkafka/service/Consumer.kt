package com.neyas.springkafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {
    private val logger: Logger = LoggerFactory.getLogger(Consumer::class.java)

    @KafkaListener(topics = ["users"], groupId = "group_id")
    fun consume(message: String) {
        logger.info("$$ -> Consumed Message -> $message")
    }
}