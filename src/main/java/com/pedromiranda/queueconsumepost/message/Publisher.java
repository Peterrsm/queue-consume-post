package com.pedromiranda.queueconsumepost.message;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Publisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publishMessage(String queue, String msg) throws IOException, TimeoutException {
        MessageToSend message = new MessageToSend(queue, msg);
        rabbitTemplate.convertAndSend(message.getQueue_name(), message.getMessage());
    }
}
