package main

import (
	"fmt"
	"sync"
)

func main() {
	// load personas and hotel knowledge
	personas, err := loadPersonas("personas.json")
	if err != nil { fmt.Println("error loading personas")}

	hotels, err := loadHotels("hotels.json")
	if err != nil { fmt.Println("error loading hotels")}

	var wg sync.WaitGroup

	for {
		activePersona := getRandomPersona(personas)
		generateBookingRequest()
	}
}
