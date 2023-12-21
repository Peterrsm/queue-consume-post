package com.pedromiranda.queueconsumepost.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "simple-queue")
    public void consumeQueue(String message) {
        System.out.println("Mensagem nova recebida: " + message);
    }
}
