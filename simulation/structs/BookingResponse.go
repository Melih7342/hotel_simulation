package main

type BookingResponse struct {
	BookingId int `json:"bookingId"`
	CheckInDate string `json:"checkInDate"`
	CheckOutDate string `json:"checkOutDate"`
	GuestName string `json:"guestName"`
	Message string `json:"message"`
	Status string `json:"status"`
}
