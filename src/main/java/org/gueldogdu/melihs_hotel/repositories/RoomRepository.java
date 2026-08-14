package org.gueldogdu.melihs_hotel.repositories;

import org.gueldogdu.melihs_hotel.models.Hotel;
import org.gueldogdu.melihs_hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHotelId(Long hotelId);
}
