package org.gueldogdu.melihs_hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Long id) {
        super("Could not find hotel with id " + id);
    }
}
