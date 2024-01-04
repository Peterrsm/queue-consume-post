package com.pedromiranda.queueconsumepost.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PublisherTest {

    @Mock
    RabbitTemplate rabbitTemplate;

    @InjectMocks
    Publisher pub;

    String message = "Test Message";
    String routing_key = ".routing+key";
    String queue_name = "queue_name";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void publishMessageToQueue() throws IOException, TimeoutException {
        pub.publishMessageToQueue(queue_name, message);

        verify(rabbitTemplate, times(1)).convertAndSend(anyString(), anyString());
    }

    @Test
    void publishMessageToHeadersExchange() throws IOException {
        pub.publishMessageToHeadersExchange(message);

        verify(rabbitTemplate, times(1)).send(anyString(), anyString(), any());
    }

    @Test
    void publishMessageToDirectExchange() throws IOException {
        pub.publishMessageToDirectExchange(message, routing_key);

        verify(rabbitTemplate, times(1)).send(anyString(), anyString(), any());
    }

    @Test
    void publishMessageToFannoutExchange() throws IOException {
        pub.publishMessageToFannoutExchange(message);

        verify(rabbitTemplate, times(1)).send(anyString(), anyString(), any());
    }

    @Test
    void publishMessageToTopicExchange() throws IOException {
        pub.publishMessageToTopicExchange(message, routing_key);

        verify(rabbitTemplate, times(1)).send(anyString(), anyString(), any());
    }
}