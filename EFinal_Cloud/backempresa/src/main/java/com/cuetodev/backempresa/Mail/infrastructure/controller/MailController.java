package com.cuetodev.backempresa.Mail.infrastructure.controller;

import com.cuetodev.backempresa.Mail.application.port.MailPort;
import com.cuetodev.backempresa.Mail.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v0")
public class MailController {

    @Autowired
    private MailPort mailPort;

    @GetMapping("/mails")
    public ResponseEntity<?> getMails(
            @RequestParam(required = false, defaultValue = "noCity") String city,
            @RequestParam String lowerDate,
            @RequestParam String upperDate,
            @RequestParam(required = false, defaultValue = "-1") Float lowerHour,
            @RequestParam(required = false, defaultValue = "-1") Float upperHour
    ) {
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("city", city);
        conditions.put("lowerDate", lowerDate);
        conditions.put("upperDate", upperDate);
        conditions.put("lowerHour", lowerHour);
        conditions.put("upperHour", upperHour);

        List<Mail> mailList = mailPort.getMailsByConditions(conditions);

        return new ResponseEntity<>(mailList, HttpStatus.OK);
    }



}
