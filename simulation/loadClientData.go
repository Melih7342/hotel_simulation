package main

import (
	"encoding/json"
	"os"
	"fmt"
)

func loadPersonas(filepath string) ([]Persona, error) {
	bytes, err := os.ReadFile(filepath)
	if err != nil { return nil, fmt.Errorf("error reading persona-file: %v", err) }

	var personas []Persona

	if err := json.Unmarshal(bytes, &personas); err != nil {
		return nil, fmt.Errorf("error parsing persona-file: %v", err)
	}

	return personas, nil
}

func loadHotels(filepath string) ([]Hotel, error) {
	bytes, err := os.ReadFile(filepath)
	if err != nil { return nil, fmt.Errorf("error reading hotels-file: %v", err) }

	var hotels []Hotel

	if err := json.Unmarshal(bytes, &hotels); err != nil {
		return nil, fmt.Errorf("error parsing hotels-file: %v", err)
	}

	return hotels, nil
}
