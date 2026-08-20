package org.gueldogdu.melihs_hotel.dtos;

import lombok.Builder;
import lombok.Data;
import org.gueldogdu.melihs_hotel.enums.BookingStatus;

import java.time.LocalDate;

@Data
@Builder
public class BookingResponseDTO {
    private Long bookingId;
    private BookingStatus status;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String guestName;
    private String message;
}
