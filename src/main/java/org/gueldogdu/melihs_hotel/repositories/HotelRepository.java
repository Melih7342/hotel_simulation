package org.gueldogdu.melihs_hotel.repositories;

import org.gueldogdu.melihs_hotel.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
