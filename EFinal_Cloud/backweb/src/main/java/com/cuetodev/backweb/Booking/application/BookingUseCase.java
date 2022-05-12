package com.cuetodev.backweb.Booking.application;

import com.cuetodev.backweb.Booking.application.port.BookingPort;
import com.cuetodev.backweb.Booking.domain.Booking;
import com.cuetodev.backweb.Booking.infrastructure.repository.port.BookingRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingUseCase implements BookingPort {
    @Autowired
    BookingRepositoryPort bookingRepositoryPort;

    @Override
    public Booking postBooking(Booking bookingReceived) {
        return bookingRepositoryPort.postBooking(bookingReceived);
    }
}
