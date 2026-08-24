package main

import (
	"fmt"
	"net/http"
)

func cancelBooking(bookingId int) error {
	url := fmt.Sprintf("http://localhost:8080/cancel/%d", bookingId)

	req, err := http.NewRequest("DELETE", url, nil)
	if err != nil { return err }

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil { return err }

	defer resp.Body.Close()

	if resp.StatusCode != http.StatusOK && resp.StatusCode != http.StatusNoContent {
		return fmt.Errorf("unexpected status code for cancellation: %d", resp.StatusCode)
	}

	return nil
}
