package main

import (
	"bytes"
	"encoding/json"
	"net/http"
)

func sendBooking(request BookingRequest) error {
	jsonRequest, err := json.Marshal(request)

	if err != nil {
		return err
	}

	bodyReader := bytes.NewBuffer(jsonRequest)

	response, err := http.Post("http://localhost:8080/booking", "application/json", bodyReader)

	if err != nil {
		return err
	}

	defer response.Body.Close()

}
