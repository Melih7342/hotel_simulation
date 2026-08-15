package org.gueldogdu.melihs_hotel.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO {

    @NotNull(message = "A hotel-ID must be provided")
    private Long hotelId;

    @NotNull(message = "A room-ID must be provided")
    private Long roomId;

    @NotNull(message = "A checkin date must be provided")
    @FutureOrPresent(message = "The checkin date can't be in the past")
    private LocalDate checkInDate;

    @NotNull(message = "A checkout date must be provided")
    @Future(message = "The checkout date must be in the future")
    private LocalDate checkOutDate;

}
