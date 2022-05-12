package com.cuetodev.backweb.Booking.infrastructure.repository;

import com.cuetodev.backweb.Booking.domain.Booking;
import com.cuetodev.backweb.Booking.infrastructure.repository.jpa.BookingRepositoryJPA;
import com.cuetodev.backweb.Booking.infrastructure.repository.port.BookingRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingRepository implements BookingRepositoryPort {

    @Autowired
    private BookingRepositoryJPA bookingRepositoryJPA;


    @Override
    public Booking postBooking(Booking booking) {
        return bookingRepositoryJPA.save(booking);
    }
}
