package com.cuetodev.backweb.Booking.application.port;

import com.cuetodev.backweb.Booking.domain.Booking;

public interface BookingPort {
    public Booking postBooking(Booking bookingReceived);
}
