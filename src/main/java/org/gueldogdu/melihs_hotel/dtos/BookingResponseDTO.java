package org.gueldogdu.melihs_hotel.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDTO {
    private Long bookingId;
    private String status;
    private String checkinDate;
    private String checkoutDate;
    private String message;
}
