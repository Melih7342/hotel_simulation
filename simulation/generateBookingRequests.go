package main

import (
	"math/rand"
	"time"
)

func generateBookingRequest(p Persona, hotels []Hotel) BookingRequest {
	randomIndex := rand.Intn(len(p.PreferredHotels))
	chosenHotelId := p.PreferredHotels[randomIndex]

	var selectedHotel Hotel
	for _, h := range hotels {
		if h.HotelId == chosenHotelId {
			selectedHotel = h
			break
		}
	}

	roomID := rand.Intn(selectedHotel.RoomAmount) + 1

	daysInFuture := rand.Intn(30)
	checkInDate := time.Now().AddDate(0, 0, daysInFuture)

	stayDays := p.MinStayDays
	if p.MaxStayDays > p.MinStayDays {
		stayDays += rand.Intn(p.MaxStayDays - p.MinStayDays + 1)
	}
	checkOutDate := checkInDate.AddDate(0, 0, stayDays)

	return BookingRequest{
		HotelId:      selectedHotel.HotelId,
		RoomId:       roomID,
		CheckInDate:  checkInDate.Format("2006-01-02"),
		CheckOutDate: checkOutDate.Format("2006-01-02"),
		GuestName:    p.Name,
	}
}
