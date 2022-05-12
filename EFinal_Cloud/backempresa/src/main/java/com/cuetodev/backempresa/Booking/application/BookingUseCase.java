package com.cuetodev.backempresa.Booking.application;

import com.cuetodev.backempresa.Booking.application.port.BookingPort;
import com.cuetodev.backempresa.Booking.domain.Booking;
import com.cuetodev.backempresa.Booking.infrastructure.repository.port.BookingRepositoryPort;
import com.cuetodev.backempresa.Bus.domain.Bus;
import com.cuetodev.backempresa.Bus.infrastructure.repository.port.BusRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookingUseCase implements BookingPort {
    @Autowired
    BookingRepositoryPort bookingRepositoryPort;

    @Autowired
    BusRepositoryPort busRepositoryPort;

    @Override
    public Booking postBooking(Booking bookingReceived) {
        //todo  Mandar correo al email con reserva realizada con éxito
        //todo  y mandar mensaje al backweb con kafka para que el backweb inserte
        //todo  la reserva en su BD.

        Bus bus = busRepositoryPort.getBusByData(bookingReceived.getDestinationCity(), bookingReceived.getDate(), bookingReceived.getHour());

        if (bus != null) {
            int occupiedSeats = bus.getOccupiedSeats();
            if (occupiedSeats < 40 && bus.isActive()) {
                bus.setOccupiedSeats(occupiedSeats + 1);
                bus.getBookingList().add(bookingReceived);
                // First save the book
                bookingRepositoryPort.saveBooking(bookingReceived);
                // Here I update the bus with a new book (save)
                busRepositoryPort.createUpdateBus(bus);
            } else {
                //todo Hacer lógica de lo que pasa cuando el autobús esté lleno o inactivo
            }
        } else {
            Set<Booking> bookings = new HashSet<>();
            bookings.add(bookingReceived);
            bookingRepositoryPort.saveBooking(bookingReceived);

            Bus newBus = new Bus(null, true, bookingReceived.getDestinationCity(), bookingReceived.getHour(), bookingReceived.getDate(), bookings);

            // Here I create the bus (save)
            busRepositoryPort.createUpdateBus(newBus);
        }

        return bookingRepositoryPort.postBooking(bookingReceived);
    }
}
