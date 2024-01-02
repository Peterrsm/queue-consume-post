package com.pedromiranda.queueconsumepost.message;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSend;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeoutException;

@Component
public class Publisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publishMessage(String queue, String msg) throws IOException, TimeoutException {
        MessageToSend message = new MessageToSend(queue, msg);
        rabbitTemplate.convertAndSend(message.getQueue_name(), message.getMessage());
    }

    public void publishMessageToHeadersExchange(String queue_name, String text) throws IOException {
        MessageToSend message = new MessageToSend(queue_name, text);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(message.getMessage());
        out.flush();
        out.close();

        byte[] byte_message = baos.toByteArray();
        baos.close();

        Message final_message = MessageBuilder.withBody(byte_message)
                .setHeader("item-1", "second")
                .build();

        rabbitTemplate.send("Headers-Exchange", "", final_message);
    }
}
