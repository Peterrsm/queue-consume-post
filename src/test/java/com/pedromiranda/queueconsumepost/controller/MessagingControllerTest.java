package com.pedromiranda.queueconsumepost.controller;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;
import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;
import com.pedromiranda.queueconsumepost.service.MessagingService;
import com.pedromiranda.queueconsumepost.stub.MessageToSendToQueueStub;
import com.pedromiranda.queueconsumepost.stub.MessageToSendWithRoutingKeyStub;
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

class MessagingControllerTest {

    @Mock
    MessagingService service;

    @InjectMocks
    MessagingController controller;

    MessageToSendToQueueStub message_to_queue_stub = new MessageToSendToQueueStub();
    MessageToSendWithRoutingKeyStub message_with_routing_key_stub = new MessageToSendWithRoutingKeyStub();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendMessageToQueue() throws IOException, TimeoutException {
        when(service.publishMessageToQueue(anyString(), anyString()))
                .thenReturn(new ResponseEntity("Mensagem enviada com sucesso", HttpStatus.OK));

        MessageToSendToQueue message_to_queue = message_to_queue_stub.createMessageToSendToQueue();

        ResponseEntity<String> retorno = controller.sendMessageToQueue(message_to_queue);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void sendMessageToDirectExchange() throws IOException {
        when(service.publishMessageToDirectExchange(anyString(), anyString()))
                .thenReturn(new ResponseEntity("Mensagem enviada com sucesso", HttpStatus.OK));

        MessageToSendWithRoutingKey message_with_touring_key = message_with_routing_key_stub.createMessageToSendWithRoutingKey();

        ResponseEntity<String> retorno = controller.sendMessageToDirectExchange(message_with_touring_key);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void sendMessageToFannoutExchange() throws IOException, TimeoutException {
        when(service.publishMessageToFannoutExchange(anyString()))
                .thenReturn(new ResponseEntity("Mensagem enviada com sucesso", HttpStatus.OK));

        MessageToSendToQueue message_to_queue = message_to_queue_stub.createMessageToSendToQueue();

        ResponseEntity<String> retorno = controller.sendMessageToFannoutExchange(message_to_queue);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void sendMessageToTopicExchange() throws IOException {
        when(service.publishMessageToTopicExchange(anyString(), anyString()))
                .thenReturn(new ResponseEntity("Mensagem enviada com sucesso", HttpStatus.OK));

        MessageToSendWithRoutingKey message_with_touring_key = message_with_routing_key_stub.createMessageToSendWithRoutingKey();

        ResponseEntity<String> retorno = controller.sendMessageToTopicExchange(message_with_touring_key);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }

    @Test
    void sendMessageToHeaderExchange() throws IOException {
        when(service.publishMessageToHeadersExchange(anyString()))
                .thenReturn(new ResponseEntity("Mensagem enviada com sucesso", HttpStatus.OK));

        MessageToSendToQueue message_to_queue = message_to_queue_stub.createMessageToSendToQueue();

        ResponseEntity<String> retorno = controller.sendMessageToHeaderExchange(message_to_queue);

        Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertEquals("Mensagem enviada com sucesso", retorno.getBody());
    }
}