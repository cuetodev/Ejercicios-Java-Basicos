package com.cuetodev.backempresa.Mail.application.port;

import com.cuetodev.backempresa.Mail.domain.Mail;

import java.util.HashMap;
import java.util.List;

public interface MailPort {
    public Mail postMail(Mail mailReceived);
    public List<Mail> getMailsByConditions(HashMap<String, Object> conditions);
}
