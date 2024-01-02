package com.pedromiranda.queueconsumepost.controller.interfaces;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IMessagingController {

    @PostMapping("/")
    void sendMessageToQueue(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;

    @PostMapping("/direct-exchange/")
    void sendMessageToDirectExchange(@RequestBody MessageToSendWithRoutingKey message) throws IOException, TimeoutException;

    @PostMapping("/fannout-exchange/")
    void sendMessageToFannoutExchange(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;

    @PostMapping("/topic-exchange/")
    void sendMessageToTopicExchange(@RequestBody MessageToSendWithRoutingKey message) throws IOException, TimeoutException;

    @PostMapping("/header-exchange/")
    void sendMessageToHeaderExchange(@RequestBody MessageToSendToQueue message) throws IOException, TimeoutException;
}
