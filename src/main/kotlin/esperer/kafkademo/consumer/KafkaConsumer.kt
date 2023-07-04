package esperer.kafkademo.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    private val logger = LoggerFactory.getLogger("kafka")

    @KafkaListener(topics = ["hub1"], groupId = "myGroup1")
    fun consume(message: String) {
        logger.info("[CONSUMER] message: $message")

        try {
            Thread.sleep(5000L)
        } catch(e: InterruptedException){
            e.printStackTrace()
        }

        logger.info("end of sleep")
    }
}