package com.cuetodev.backempresa.Bus.infrastructure.controller.dto.output;

import com.cuetodev.backempresa.Bus.domain.Bus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusAvailabilityOutputDTO {
    private String city;
    private String departureDate;
    private Float departureHour;
    private Integer availableSeats;

    public BusAvailabilityOutputDTO(Bus bus) {
        setCity(bus.getCity());
        setDepartureDate(bus.getDate().toString());
        setDepartureHour(bus.getHour());
        setAvailableSeats(40 - bus.getOccupiedSeats());
    }
}
