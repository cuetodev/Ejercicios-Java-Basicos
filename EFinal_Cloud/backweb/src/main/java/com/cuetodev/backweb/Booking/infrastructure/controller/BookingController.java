package com.cuetodev.backweb.Booking.infrastructure.controller;

import com.cuetodev.backweb.Booking.application.port.BookingPort;
import com.cuetodev.backweb.Booking.domain.Booking;
import com.cuetodev.backweb.Booking.infrastructure.controller.dto.input.BookingInputDTO;
import com.cuetodev.backweb.Booking.infrastructure.controller.dto.output.BookingOutPutDTO;
import com.cuetodev.backweb.ErrorHandling.ErrorOutPutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("api/v0/booking")
public class BookingController {

    @Autowired
    private BookingPort bookingPort;

    @PostMapping
    public ResponseEntity<?> postBooking(@RequestBody BookingInputDTO bookingInputDTO) throws ParseException {
        Booking bookingReceived = null;
        Booking bookingBack = null;

        try {
            bookingReceived = bookingInputDTO.convertInputDtoToEntity();
            //todo Comprobar si de verdad existen plazas para el autobus haciendo una llamada al BackEmpresa y si se completa la reserva mandar un mensaje al email
            //todo Hacer llamada mediante Kafka
            bookingBack = bookingPort.postBooking(bookingReceived);
        } catch (Exception e) {
            return new ResponseEntity<ErrorOutPutDTO>(new ErrorOutPutDTO(400, "Invalidad booking", "Fatal"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<BookingOutPutDTO>(new BookingOutPutDTO(bookingBack), HttpStatus.OK);
    }

}
