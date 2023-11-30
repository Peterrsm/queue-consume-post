package com.pedromiranda.queueconsumepost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class QueueConsumePostApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueConsumePostApplication.class, args);
    }
}
