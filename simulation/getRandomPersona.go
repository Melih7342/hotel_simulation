package main

import (
	"fmt"
	"math/rand"
)

func getRandomPersona(personas []Persona) Persona {
	totalWeight := 0
	for _, p := range personas {
		totalWeight += p.Weight
	}

	if totalWeight == 0 {
		fmt.Print("Could not read any persona weights, returning the first persona")
		return personas[0]
	}

	randomValue := rand.Intn(totalWeight)

	currentWeight := 0
	for _, p := range personas {
		currentWeight += p.Weight

		if randomValue < currentWeight {
			return p
		}
	}

	// Fallback
	return personas[0]
}
