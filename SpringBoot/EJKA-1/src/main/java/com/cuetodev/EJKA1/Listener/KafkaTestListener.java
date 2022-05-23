package com.cuetodev.EJKA1.Listener;

import com.cuetodev.EJKA1.Test.Test;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestListener {

    @KafkaListener(topics = "test", groupId = "${message.group.name1:testgroup}")
    public void listenTopic1(String stringObject) {
        System.out.println("****** OBJETO EN STRING ******");
        System.out.println(stringObject);

        Test test = new Gson().fromJson(stringObject, Test.class);

        System.out.println("****** OBJECTO YA CREADO ******");
        System.out.println(test.getName() + " " + test.getAge() + " " + test.isActive());


    }
}
