package org.gueldogdu.melihs_hotel.services;

import lombok.RequiredArgsConstructor;
import org.gueldogdu.melihs_hotel.HotelNotFoundException;
import org.gueldogdu.melihs_hotel.models.Hotel;
import org.gueldogdu.melihs_hotel.models.Room;
import org.gueldogdu.melihs_hotel.repositories.HotelRepository;
import org.gueldogdu.melihs_hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomProvisioningService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Transactional
    public void provisionRoomsForHotel(Long hotelId, int roomsPerFloor) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));

        List<Room> generatedRooms = new ArrayList<>();

        for (int floor = 1; floor <= hotel.getFloors(); floor++) {

            for (int roomNumber = 1; roomNumber <= roomsPerFloor; roomNumber++) {

                String formattedRoomNum = String.format("%d%02d", floor, roomNumber);

                Room newRoom = new Room(
                        hotel.getHotelId(),
                        2,
                        "Standard Room " + formattedRoomNum,
                        89.90,
                        "Queen Size"
                );

                generatedRooms.add(newRoom);
            }
        }

        roomRepository.saveAll(generatedRooms);

        System.out.println(generatedRooms.size() + " rooms successfully added to hotel " + hotel.getName());
    }
}