package org.gueldogdu.melihs_hotel.services;

import lombok.RequiredArgsConstructor;
import org.gueldogdu.melihs_hotel.enums.BookingStatus;
import org.gueldogdu.melihs_hotel.exceptions.RoomAlreadyBookedException;
import org.gueldogdu.melihs_hotel.models.Booking;
import org.gueldogdu.melihs_hotel.repositories.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository  bookingRepository;

    @Transactional
    public Booking createBooking(Long hotelId, Long roomId, LocalDate requestedCheckIn, LocalDate requestedCheckOut, String guestName) {
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(hotelId, roomId, requestedCheckIn, requestedCheckOut);

        if (!overlappingBookings.isEmpty()) {
            throw new RoomAlreadyBookedException(roomId, requestedCheckIn, requestedCheckOut);
        }
        Booking booking = new Booking();
        booking.setHotelId(hotelId);
        booking.setRoomId(roomId);
        booking.setCheckInDate(requestedCheckIn);
        booking.setCheckOutDate(requestedCheckOut);
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setGuestName(guestName);
        bookingRepository.save(booking);

        return booking;
    }
}
