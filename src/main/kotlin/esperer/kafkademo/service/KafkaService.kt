package esperer.kafkademo.service

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val logger = LoggerFactory.getLogger("kafka")

    fun insert(): String {

        val future = kafkaTemplate.send("hub1", null.toString(), LocalDateTime.now().toString())

        future.addCallback(
            { successCallback ->
                if (successCallback != null) {
                    logger.info("[producer] successCallback. offset: ${successCallback.recordMetadata.offset()}")
                }
            },
            { errorCallback ->
                logger.error("[producer] errorCallback. msg: ${errorCallback.message}")
            }
        )


        return "{}"
    }
}