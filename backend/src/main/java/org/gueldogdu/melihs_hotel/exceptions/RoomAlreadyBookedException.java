package org.gueldogdu.melihs_hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomAlreadyBookedException extends RuntimeException {
    public RoomAlreadyBookedException(Long roomId, LocalDate requestedCheckIn, LocalDate requestedCheckOut) {
        super(String.format("Room %d is already booked between %s and %s!", roomId, requestedCheckIn, requestedCheckOut));
    }
}
