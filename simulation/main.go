package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

func main() {
	// load personas and hotel knowledge
	personas, err := loadPersonas("personas.json")
	if err != nil {
		fmt.Printf("error loading personas: %v\n", err)
	}

	hotels, err := loadHotels("hotels.json")
	if err != nil {
		fmt.Printf("error loading hotels: %v\n", err)
	}

	var wg sync.WaitGroup

	for i := 0; i < 1000; i++ {
		wg.Add(1)

		activePersona := getRandomPersona(personas)

		request := generateBookingRequest(activePersona, hotels)

		go func(req BookingRequest) {
			defer wg.Done()
			err := sendBooking(req)
			if err != nil { fmt.Printf("system error for the request of %s: %v\n", req.GuestName, err) }
		}(request)

		sleepTime := rand.Intn(450) + 50
		time.Sleep(time.Duration(sleepTime) * time.Millisecond)
	}

	fmt.Println("All 1000 request generated. wait for the rest of the responses")
	wg.Wait()
	fmt.Println("simulation successfully finished!")
}
