package org.gueldogdu.melihs_hotel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "hotel_id")
    private Long hotelId;

    private int capacity;
    private String description;
    private double pricePerNight;
    private String bedType;

    public Room (Long hotelId, int capacity,  String description, double pricePerNight,  String bedType) {
        this.hotelId = hotelId;
        this.capacity = capacity;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.bedType = bedType;
    }
}

