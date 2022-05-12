package com.cuetodev.backweb.Booking.infrastructure.repository.port;

import com.cuetodev.backweb.Booking.domain.Booking;

public interface BookingRepositoryPort {
    public Booking postBooking(Booking booking);
}
