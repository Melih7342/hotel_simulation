package org.gueldogdu.melihs_hotel.services;

import org.gueldogdu.melihs_hotel.models.Booking;
import org.gueldogdu.melihs_hotel.repositories.BookingRepository;

import java.time.LocalDate;
import java.util.List;

public class BookingService {
    BookingRepository  bookingRepository;

    public BookingService(BookingRepository bookingRepo) {
        this.bookingRepository = bookingRepo;
    }

    private void createBooking(Long hotelId, Long roomId, LocalDate requestedCheckIn, LocalDate requestedCheckOut) {
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(roomId, requestedCheckIn, requestedCheckOut);

    }
}
