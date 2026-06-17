//package com.controller;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaTestProdController {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaTestProdController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/send")
//    public String send(@RequestBody String msg){
//        kafkaTemplate.send("test-topic", msg);
//        return "Message sent to Kafka topic: " + msg;
//    }
//}
