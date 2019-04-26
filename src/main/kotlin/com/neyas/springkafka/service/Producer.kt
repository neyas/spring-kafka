package com.neyas.springkafka.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Producer {
    private val logger = LoggerFactory.getLogger(Producer::class.java)
    private val TOPIC = "users"

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(message: String) {
        logger.info("$$ -> Producing message --> $message")
        this.kafkaTemplate.send(TOPIC, message)
    }
}