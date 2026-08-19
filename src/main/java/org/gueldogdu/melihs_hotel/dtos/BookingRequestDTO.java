package org.gueldogdu.melihs_hotel.dtos;

import jakarta.validation.constraints.AssertTrue;
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

    @NotNull(message = "A check in date must be provided")
    @FutureOrPresent(message = "The check in date can't be in the past")
    private LocalDate checkInDate;

    @NotNull(message = "A check out date must be provided")
    @Future(message = "The check out date must be in the future")
    private LocalDate checkOutDate;

    @NotNull(message = "Please provide your name")
    private String guestName;

    @AssertTrue(message = "The check in date must be before the check out date")
    public boolean isCheckOutAfterCheckIn() {
        if (checkInDate == null || checkOutDate == null) {
            return true;
        }
        return checkOutDate.isAfter(checkInDate);
    }
}
