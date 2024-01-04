package com.pedromiranda.queueconsumepost.service;

import com.pedromiranda.queueconsumepost.message.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class MessagingService {
    @Autowired
    Publisher pub;

    String retorno;

    public ResponseEntity<String> publishMessageToQueue(String queue_name, String message) throws IOException, TimeoutException {
        try {
            retorno = pub.publishMessageToQueue(queue_name, message);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<String> publishMessageToDirectExchange(String message, String routing_key) throws IOException {
        try {
            retorno = pub.publishMessageToDirectExchange(message, routing_key);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<String> publishMessageToTopicExchange(String message, String routing_key) throws IOException {
        try {
            retorno = pub.publishMessageToTopicExchange(message, routing_key);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<String> publishMessageToFannoutExchange(String message) throws IOException {
        try {
            retorno = pub.publishMessageToFannoutExchange(message);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<String> publishMessageToHeadersExchange(String message) throws IOException {
        try {
            retorno = pub.publishMessageToHeadersExchange(message);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
