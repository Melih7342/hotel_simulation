package main

type Hotel struct {
	HotelId    int    `json:"hotelId"`
	Name       string `json:"name"`
	Country    string `json:"country"`
	City       string `json:"city"`
	Type       string `json:"type"`
	Floors     int    `json:"floors"`
	RoomAmount int    `json:"roomAmount"`
}
