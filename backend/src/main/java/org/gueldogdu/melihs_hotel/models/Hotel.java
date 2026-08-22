package org.gueldogdu.melihs_hotel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String name;
    private String country;
    private String city;
    private String type;
    private int floors;
    private int roomAmount;

    public Hotel(String name, String country, String city, String motto, int floors) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.type = motto;
        this.floors = floors;
    }
}
