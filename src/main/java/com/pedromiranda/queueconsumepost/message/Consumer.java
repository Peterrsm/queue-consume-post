package com.pedromiranda.queueconsumepost.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Consumer {

    ConnectionFactory factory;
    Connection connection;
    Channel channel;

    public void consumeQueue() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        connection = factory.newConnection();
        channel = connection.createChannel();

        DeliverCallback deliverCallBack = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println("Mensagem recebida: " + message);
        };
        channel.basicConsume("simple-queue", true, deliverCallBack, consumerTag -> {
        });
    }

    public void stopConsuming() throws IOException, TimeoutException {
        if (this.channel.isOpen()) {
            this.channel.close();
            System.out.println("Channel stoped");
        }

        if (this.connection.isOpen()) {
            this.connection.close();
            System.out.println("Connection stoped");
        }

    }
}
