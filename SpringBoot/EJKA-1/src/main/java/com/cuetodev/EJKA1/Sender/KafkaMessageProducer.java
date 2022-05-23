package com.cuetodev.EJKA1.Sender;

import com.cuetodev.EJKA1.Test.Test;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaMessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name:test}")
    private String topicName;

    public void sendMessage(String topic, String message) {
        if (topic==null || topic.trim().equals("")) topic = topicName;

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }

    public void sendObject(String topic, Test test) {

        String stringObject = new Gson().toJson(test);

        if (topic == null || topic.trim().equals("")) topic = topicName;

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test", stringObject);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Object send succesfully");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error sending the object");
            }
        });
    }
}
