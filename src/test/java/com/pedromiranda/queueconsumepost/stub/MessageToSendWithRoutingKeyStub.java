package com.pedromiranda.queueconsumepost.stub;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendWithRoutingKey;

public class MessageToSendWithRoutingKeyStub {

    public MessageToSendWithRoutingKey createMessageToSendWithRoutingKey() {
        return MessageToSendWithRoutingKey.builder()
                .routing_key(".first_queue.")
                .message("Mensagem a ser enviada")
                .build();
    }
}
