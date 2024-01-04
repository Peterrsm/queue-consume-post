package com.pedromiranda.queueconsumepost.message.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageToSendToQueue implements Serializable {
    String queue_name;
    String message;
}
