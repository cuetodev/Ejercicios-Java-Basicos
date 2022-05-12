package com.cuetodev.backweb.Booking.infrastructure.controller.dto.output;

import com.cuetodev.backweb.Booking.domain.Booking;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.server.UID;
import java.text.ParseException;
import java.util.Date;

@Data
@NoArgsConstructor
public class BookingOutPutDTO {
    private Integer id;
    private String destinationCity;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date date;
    private Float hour;

    public BookingOutPutDTO(Booking booking) throws ParseException {
        if (booking == null) return;
        setId(booking.getId());
        setDestinationCity(booking.getDestinationCity());
        setName(booking.getName());
        setSurname(booking.getSurname());
        setPhone(booking.getPhone());
        setEmail(booking.getEmail());
        setDate(booking.getDate());
        setHour(booking.getHour());
    }
}
