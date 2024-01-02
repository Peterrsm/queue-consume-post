package com.pedromiranda.queueconsumepost.message;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
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

    public void publishMessageToQueue(String queue, String msg) throws IOException, TimeoutException {
        MessageToSendToQueue message = new MessageToSendToQueue(queue, msg);
        rabbitTemplate.convertAndSend(message.getQueue_name(), message.getMessage());
    }

    public void publishMessageToHeadersExchange(String text) throws IOException {
        byte[] byte_message = createByteMessage(text);

        Message final_message = MessageBuilder.withBody(byte_message)
                .setHeader("item-1", "second")
                .build();

        rabbitTemplate.send("Headers-Exchange", "", final_message);
    }

    public void publishMessageToDirectExchange(String message, String routing_key) throws IOException {
        byte[] byte_message = createByteMessage(message);

        Message final_message = MessageBuilder.withBody(byte_message)
                .setReceivedRoutingKey(routing_key)
                .build();

        rabbitTemplate.send("Direct-Exchange", routing_key, final_message);
    }

    public void publishMessageToFannoutExchange(String message) throws IOException {
        byte[] byte_message = createByteMessage(message);

        Message final_message = MessageBuilder.withBody(byte_message)
                .build();

        rabbitTemplate.send("Fannout-Exchange", "", final_message);
    }

    public void publishMessageToTopicExchange(String message, String routing_key) throws IOException {
        byte[] byte_message = createByteMessage(message);

        Message final_message = MessageBuilder.withBody(byte_message)
                .setReceivedRoutingKey(routing_key)
                .build();

        rabbitTemplate.send("Topic-Exchange", routing_key, final_message);
    }

    private byte[] createByteMessage(String message) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(message);
        out.flush();
        out.close();

        byte[] byte_message = baos.toByteArray();
        baos.close();

        return byte_message;
    }
}
