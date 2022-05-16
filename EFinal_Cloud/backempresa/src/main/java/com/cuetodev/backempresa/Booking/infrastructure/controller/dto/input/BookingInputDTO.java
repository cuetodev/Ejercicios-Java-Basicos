package com.cuetodev.backempresa.Booking.infrastructure.controller.dto.input;

import com.cuetodev.backempresa.Booking.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingInputDTO {

    private String city;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date date;
    private Float hour;

    public Booking convertInputDtoToEntity() {
        return new Booking(null, city, name, surname, phone, email, date, hour, null, null);
    }
}
