package com.cuetodev.backempresa.Booking.infrastructure.controller;

import com.cuetodev.backempresa.Booking.application.port.BookingPort;
import com.cuetodev.backempresa.Booking.domain.Booking;
import com.cuetodev.backempresa.Booking.infrastructure.controller.dto.input.BookingInputDTO;
import com.cuetodev.backempresa.Booking.infrastructure.controller.dto.output.BookingOutPutDTO;
import com.cuetodev.backempresa.ErrorHandling.ErrorOutPutDTO;
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
            bookingBack = bookingPort.postBooking(bookingReceived);
        } catch (Exception e) {
            return new ResponseEntity<ErrorOutPutDTO>(new ErrorOutPutDTO(400, "Invalidad booking", "Fatal"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<BookingOutPutDTO>(new BookingOutPutDTO(bookingBack), HttpStatus.OK);
    }

}
