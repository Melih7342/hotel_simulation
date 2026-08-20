package main

type BookingRequest struct {
	HotelId int `json:"hotelId"`
	RoomId int `json:"roomId"`
	CheckInDate string `json:"checkInDate"`
	CheckOutDate string `json:"checkOutDate"`
	GuestName string `json:"guestName"`
}