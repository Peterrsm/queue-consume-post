package com.pedromiranda.queueconsumepost.message.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageToSend implements Serializable {
    String queue_name;
    String message;
}
