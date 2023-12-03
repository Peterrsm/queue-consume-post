package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.controller.interfaces.IMessagingController;
import com.pedromiranda.queueconsumepost.message.Consumer;
import com.pedromiranda.queueconsumepost.message.MessageToSend;
import com.pedromiranda.queueconsumepost.message.Publisher;
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
        pub.publishMessage(message.getMessage());
    }

    @Override
    public void consumeQueue() throws IOException, TimeoutException {
        cons.consumeQueue();
    }

    @Override
    public void stopConsuming() throws IOException, TimeoutException {
        cons.stopConsuming();
    }
}