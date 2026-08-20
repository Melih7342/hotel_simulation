package org.gueldogdu.melihs_hotel.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gueldogdu.melihs_hotel.exceptions.HotelNotFoundException;
import org.gueldogdu.melihs_hotel.models.Hotel;
import org.gueldogdu.melihs_hotel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public void registerHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Transactional
    public void changeName(Long id, String newName) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotel.setName(newName);
    }

    @Transactional
    public void changeMotto(Long id, String newMotto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        hotel.setMotto(newMotto);
    }

}
