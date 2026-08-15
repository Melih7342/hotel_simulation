package org.gueldogdu.melihs_hotel.exceptions;

import java.time.LocalDate;

public class RoomAlreadyBookedException extends RuntimeException {
    public RoomAlreadyBookedException(Long roomId, LocalDate requestedCheckIn, LocalDate requestedCheckOut) {
        super(String.format("Room %d is already booked between %s and %s!", roomId, requestedCheckIn, requestedCheckOut));
    }
}
