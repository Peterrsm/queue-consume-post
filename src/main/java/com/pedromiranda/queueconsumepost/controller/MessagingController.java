package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.controller.interfaces.IMessagingController;
import com.pedromiranda.queueconsumepost.message.Consumer;
import com.pedromiranda.queueconsumepost.message.Publisher;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSend;
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
    public void sendMessageToQueue(MessageToSend message) throws IOException, TimeoutException {
        pub.publishMessage(message.getQueue_name(), message.getMessage());
    }

    @Override
    public void sendMessageToDirectExchange(MessageToSend message) throws IOException, TimeoutException {
        pub.publishMessage(message.getQueue_name(), message.getMessage());
    }

    @Override
    public void sendMessageToFannoutExchange(MessageToSend message) throws IOException, TimeoutException {

    }

    @Override
    public void sendMessageToTopicExchange(MessageToSend message) throws IOException, TimeoutException {

    }

    @Override
    public void sendMessageToHeaderExchange(MessageToSend message) throws IOException, TimeoutException {
        pub.publishMessageToHeadersExchange(message.getQueue_name(), message.getMessage());
    }
}