package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.message.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/message")
public class MessagingController {
    @Autowired
    Publisher pub = new Publisher();

    @PostMapping
    public void sendMessage() throws IOException, TimeoutException {
        pub.publishMessage("Mensagem teste");
    }

}
