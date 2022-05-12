package com.cuetodev.backempresa.Booking.application.port;

import com.cuetodev.backempresa.Booking.domain.Booking;

public interface BookingPort {
    public Booking postBooking(Booking bookingReceived);
}
