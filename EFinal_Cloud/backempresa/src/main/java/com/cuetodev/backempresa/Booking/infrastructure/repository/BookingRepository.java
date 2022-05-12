package com.cuetodev.backempresa.Booking.infrastructure.repository;

import com.cuetodev.backempresa.Booking.domain.Booking;
import com.cuetodev.backempresa.Booking.infrastructure.repository.jpa.BookingRepositoryJPA;
import com.cuetodev.backempresa.Booking.infrastructure.repository.port.BookingRepositoryPort;
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

    @Override
    public void saveBooking(Booking booking) {
        bookingRepositoryJPA.save(booking);
    }
}
