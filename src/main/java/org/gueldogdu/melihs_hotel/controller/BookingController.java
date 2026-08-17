package org.gueldogdu.melihs_hotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.gueldogdu.melihs_hotel.dtos.BookingRequestDTO;
import org.gueldogdu.melihs_hotel.dtos.BookingResponseDTO;
import org.gueldogdu.melihs_hotel.models.Booking;
import org.gueldogdu.melihs_hotel.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO){
        Booking booking = bookingService.createBooking(
                bookingRequestDTO.getHotelId(),
                bookingRequestDTO.getRoomId(),
                bookingRequestDTO.getCheckInDate(),
                bookingRequestDTO.getCheckOutDate(),
                bookingRequestDTO.getGuestName());

        BookingResponseDTO response = BookingResponseDTO.builder()
                .bookingId(booking.getBookingId())
                .status(booking.getStatus())
                .checkinDate(booking.getCheckInDate())
                .checkoutDate(booking.getCheckOutDate())
                .guestName(booking.getGuestName())
                .message(String.format("Room %d successfully reserved for %s from %s to %s.", booking.getRoomId(), booking.getCheckInDate(), booking.getCheckOutDate(), booking.getGuestName()))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
