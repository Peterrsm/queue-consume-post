package com.pedromiranda.queueconsumepost.message.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageToSendWithRoutingKey implements Serializable {
    String routing_key;
    String message;
}
