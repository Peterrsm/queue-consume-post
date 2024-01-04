package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.controller.interfaces.IMessagingController;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;
import com.pedromiranda.queueconsumepost.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/message")
public class MessagingController implements IMessagingController {
    @Autowired
    MessagingService service;

    @Override
    public ResponseEntity<String> sendMessageToQueue(MessageToSendToQueue message) throws IOException, TimeoutException {
        return service.publishMessageToQueue(message.getQueue_name(), message.getMessage());
    }

    @Override
    public ResponseEntity<String> sendMessageToDirectExchange(MessageToSendWithRoutingKey message) throws IOException {
        return service.publishMessageToDirectExchange(message.getMessage(), message.getRouting_key());
    }

    @Override
    public ResponseEntity<String> sendMessageToFannoutExchange(MessageToSendToQueue message) throws IOException {
        return service.publishMessageToFannoutExchange(message.getMessage());
    }

    @Override
    public ResponseEntity<String> sendMessageToTopicExchange(MessageToSendWithRoutingKey message) throws IOException {
        return service.publishMessageToTopicExchange(message.getMessage(), message.getRouting_key());
    }

    @Override
    public ResponseEntity<String> sendMessageToHeaderExchange(MessageToSendToQueue message) throws IOException {
        return service.publishMessageToHeadersExchange(message.getMessage());
    }
}