package com.cuetodev.backempresa.Mail.application;

import com.cuetodev.backempresa.Booking.domain.Booking;
import com.cuetodev.backempresa.Booking.infrastructure.repository.port.BookingRepositoryPort;
import com.cuetodev.backempresa.Mail.application.port.MailPort;
import com.cuetodev.backempresa.Mail.domain.Mail;
import com.cuetodev.backempresa.Mail.infrastructure.repository.port.MailRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MailUseCase implements MailPort {

    @Autowired
    MailRepositoryPort mailRepositoryPort;

    @Autowired
    BookingRepositoryPort bookingRepositoryPort;


    @Override
    public Mail postMail(Mail mailReceived) {
        return mailRepositoryPort.postMail(mailReceived);
    }

    @Override
    public List<Mail> getMailsByConditions(HashMap<String, Object> conditions) {
        List<Booking> bookings = bookingRepositoryPort.getBookingsByConditions(conditions);
        List<Mail> mailList = new ArrayList<>();

        // Here Im accessing to the mail HashSet in each booking so I add every mail into one list to return the list
        bookings.forEach(booking -> mailList.addAll(booking.getMailSet()));

        return mailList;
    }
}
