package com.cuetodev.backempresa.Bus.infrastructure.controller.dto.input;

import com.cuetodev.backempresa.Booking.domain.Booking;
import com.cuetodev.backempresa.Bus.domain.Bus;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class BusInputDTO {
    private Integer id;

    @NotNull
    private boolean active;

    @NotNull
    private String city;

    @NotNull
    private int occupiedSeats;

    @NotNull
    private Float hour;

    @NotNull
    private Date date;

    private Set<Booking> bookingSet;

    public Bus convertToEntity() {
        return new Bus(null, active, city, hour, date, bookingSet);
    }
}
