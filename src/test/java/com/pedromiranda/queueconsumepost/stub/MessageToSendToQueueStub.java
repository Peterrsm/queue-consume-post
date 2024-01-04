package com.pedromiranda.queueconsumepost.stub;

import com.pedromiranda.queueconsumepost.message.objects.MessageToSendToQueue;

public class MessageToSendToQueueStub {

    public MessageToSendToQueue createMessageToSendToQueue() {
        return MessageToSendToQueue.builder()
                .queue_name("queue_name")
                .message("Mensagem a ser enviada")
                .build();
    }
}
