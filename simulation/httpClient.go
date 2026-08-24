package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"net/http"
)

func sendBooking(request BookingRequest) (int, error) {
	// 1. Marshalling
	jsonRequest, err := json.Marshal(request)
	if err != nil {
		return 0, err
	}

	// 2. Buffer
	bodyReader := bytes.NewBuffer(jsonRequest)

	// 3. Request
	response, err := http.Post("http://localhost:8080/book", "application/json", bodyReader)
	if err != nil {
		return 0, err
	}

	// 4. Cleanup
	defer response.Body.Close()

	// 5. Status Evaluation
	switch response.StatusCode {

	case http.StatusCreated: // 201
		var successResponse BookingResponse
		if err := json.NewDecoder(response.Body).Decode(&successResponse); err != nil {
			return 0, fmt.Errorf("failed to decode success response: %v", err)
		}
		fmt.Printf("✅ SUCCESS: Room successfully booked for %s!\n", successResponse.GuestName)
		return successResponse.BookingId, nil

	case http.StatusConflict: // 409
		fmt.Println("❌ CONFLICT: Room is already booked for this period!")
		return 0, nil

	case http.StatusBadRequest: // 400
		fmt.Println("⚠️ BAD REQUEST: Formal DTO validation failed!")
		return 0, nil

	default:
		// e.g. 500 Internal Server Error
		return 0, fmt.Errorf("unexpected status code from server: %d", response.StatusCode)
	}
}

