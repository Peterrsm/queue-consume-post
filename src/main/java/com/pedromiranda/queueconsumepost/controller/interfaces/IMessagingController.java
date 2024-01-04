package com.pedromiranda.queueconsumepost.controller.interfaces;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IMessagingController {

    @PostMapping("/")
    ResponseEntity<String> sendMessageToQueue(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;

    @PostMapping("/direct-exchange/")
    ResponseEntity<String> sendMessageToDirectExchange(@RequestBody MessageToSendWithRoutingKey message) throws IOException, TimeoutException;

    @PostMapping("/fannout-exchange/")
    ResponseEntity<String> sendMessageToFannoutExchange(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;

    @PostMapping("/topic-exchange/")
    ResponseEntity<String> sendMessageToTopicExchange(@RequestBody MessageToSendWithRoutingKey message) throws IOException, TimeoutException;

    @PostMapping("/header-exchange/")
    ResponseEntity<String> sendMessageToHeaderExchange(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;
}
