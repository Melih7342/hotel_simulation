package main

import "fmt"

func main() {
	testBooking := BookingRequest{
		HotelId:      5,
		RoomId:       100,
		CheckInDate:  "2027-01-01",
		CheckOutDate: "2027-01-08",
		GuestName:    "Melih",
	}

	err := sendBooking(testBooking)
	if err != nil {fmt.Printf("❌ Critical error: Could not reach server - %v\n", err)}
}
