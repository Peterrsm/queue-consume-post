package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.controller.interfaces.IMessagingController;
import com.pedromiranda.queueconsumepost.message.Consumer;
import com.pedromiranda.queueconsumepost.message.Publisher;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/message")
public class MessagingController implements IMessagingController {
    @Autowired
    Publisher pub = new Publisher();

    @Autowired
    Consumer cons = new Consumer();

    @Override
    public void sendMessageToQueue(MessageToSendToQueue message) throws IOException, TimeoutException {
        pub.publishMessageToQueue(message.getQueue_name(), message.getMessage());
    }

    @Override
    public void sendMessageToDirectExchange(MessageToSendWithRoutingKey message) throws IOException, TimeoutException {
        pub.publishMessageToDirectExchange(message.getMessage(), message.getRouting_key());
    }

    @Override
    public void sendMessageToFannoutExchange(MessageToSendToQueue message) throws IOException, TimeoutException {
        pub.publishMessageToFannoutExchange(message.getMessage());
    }

    @Override
    public void sendMessageToTopicExchange(MessageToSendWithRoutingKey message) throws IOException, TimeoutException {
        pub.publishMessageToTopicExchange(message.getMessage(), message.getRouting_key());
    }

    @Override
    public void sendMessageToHeaderExchange(MessageToSendToQueue message) throws IOException, TimeoutException {
        pub.publishMessageToHeadersExchange(message.getMessage());
    }
}