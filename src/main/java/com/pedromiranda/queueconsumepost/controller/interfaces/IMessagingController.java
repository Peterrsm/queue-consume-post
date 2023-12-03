package com.pedromiranda.queueconsumepost.controller.interfaces;

import com.pedromiranda.queueconsumepost.message.MessageToSend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IMessagingController {

    @PostMapping("/")
    void sendMessageToQueue(@RequestBody MessageToSend message) throws IOException, TimeoutException;

    @GetMapping("/")
    void consumeQueue() throws IOException, TimeoutException;

    @PostMapping("/stop")
    void stopConsuming() throws IOException, TimeoutException;
}
