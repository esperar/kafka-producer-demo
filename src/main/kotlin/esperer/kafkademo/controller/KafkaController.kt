package esperer.kafkademo.controller

import esperer.kafkademo.service.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController(
    private val kafkaService: KafkaService
) {

    @GetMapping("/insert")
    fun insert(): String {
        return kafkaService.insert()
    }
}