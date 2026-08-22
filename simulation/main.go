package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup

	fmt.Println("🚀 Starte Lasttest: Feuere 50 parallele Buchungen ab...")

	for {
		wg.Add(1)

		guestName := fmt.Sprintf("Melih-%d", i)

		booking := BookingRequest{
			HotelId:      5,
			RoomId:       200 + i,
			CheckInDate:  "2027-01-01",
			CheckOutDate: "2027-01-08",
			GuestName:    guestName,
		}

		go func(req BookingRequest) {
			defer wg.Done()

			err := sendBooking(req)
			if err != nil {
				fmt.Printf("❌ Kritischer Fehler bei %s: %v\n", req.GuestName, err)
			}
		}(testBooking)
	}

	wg.Wait()

	fmt.Println("🏁 Lasttest erfolgreich beendet!")
}
