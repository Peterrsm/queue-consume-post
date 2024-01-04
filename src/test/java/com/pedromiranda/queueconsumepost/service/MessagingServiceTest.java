package com.pedromiranda.queueconsumepost.service;

import com.pedromiranda.queueconsumepost.message.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MessagingServiceTest {

    @Mock
    Publisher pub;

    @InjectMocks
    MessagingService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    String message = "Test Message";
    String routing_key = ".routing+key";
    String queue_name = "queue_name";

    @Test
    void publishMessageToQueue() throws IOException, TimeoutException {
        when(pub.publishMessageToQueue(anyString(), anyString()))
                .thenReturn("Mensagem enviada com sucesso");


        ResponseEntity<String> retorno = service.publishMessageToQueue(queue_name, message);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void publishMessageToDirectExchange() throws IOException, TimeoutException {
        when(pub.publishMessageToDirectExchange(anyString(), anyString()))
                .thenReturn("Mensagem enviada com sucesso");

        ResponseEntity<String> retorno = service.publishMessageToDirectExchange(message, routing_key);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void publishMessageToTopicExchange() throws IOException, TimeoutException {
        when(pub.publishMessageToTopicExchange(anyString(), anyString()))
                .thenReturn("Mensagem enviada com sucesso");

        ResponseEntity<String> retorno = service.publishMessageToTopicExchange(message, routing_key);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());

    }

    @Test
    void publishMessageToFannoutExchange() throws IOException {
        when(pub.publishMessageToFannoutExchange(anyString()))
                .thenReturn("Mensagem enviada com sucesso");

        ResponseEntity<String> retorno = service.publishMessageToFannoutExchange(message);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());


    }

    @Test
    void publishMessageToHeadersExchange() throws IOException, TimeoutException {
        when(pub.publishMessageToHeadersExchange(anyString()))
                .thenReturn("Mensagem enviada com sucesso");

        ResponseEntity<String> retorno = service.publishMessageToHeadersExchange(message);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }
}