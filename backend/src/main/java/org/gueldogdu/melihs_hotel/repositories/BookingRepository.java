package org.gueldogdu.melihs_hotel.repositories;

import org.gueldogdu.melihs_hotel.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("""
        SELECT b FROM Booking b
        WHERE b.hotelId = :hotelId
            AND b.roomId = :roomId
            AND b.status != 'CANCELLED'
            AND b.checkInDate < :requestedCheckOut
            AND b.checkOutDate > :requestedCheckIn
        """)
    List<Booking> findOverlappingBookings(
            @Param("hotelId") Long hotelId,
            @Param("roomId") Long roomId,
            @Param("requestedCheckIn") LocalDate checkIn,
            @Param("requestedCheckOut") LocalDate checkOut
    );

    void findByBookingId(Long bookingId);

    void deleteBookingByBookingId(Long bookingId);
}
