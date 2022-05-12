package com.cuetodev.backempresa.Booking.infrastructure.repository.port;

import com.cuetodev.backempresa.Booking.domain.Booking;

public interface BookingRepositoryPort {
    public Booking postBooking(Booking booking);
    public void saveBooking(Booking booking);
}
