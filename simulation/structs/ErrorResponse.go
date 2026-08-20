package main

type ErrorResponse struct {
	Timestamp string `json:"timestamp"`
	Error string `json:"error"`
	Status string `json:"status"`
	Message string `json:"message"`
}
