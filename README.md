# Hotel Booking Chaos Simulator

A professional-grade, concurrent load testing and traffic simulation engine written in Go. This tool is specifically designed to stress-test a Java Spring Boot hotel booking backend connected to a PostgreSQL database. It simulates realistic, human-like booking behaviors, race conditions, and cancellations to validate database transactional integrity.

## 🚀 Key Features

* **Concurrent Request Dispatching:** Utilizes Go's Goroutines and `sync.WaitGroup` to fire asynchronous, non-blocking requests, heavily testing the backend's locking mechanisms.
* **Intentional Conflict Generation (Race Conditions):** Forces multiple concurrent users to target limited resources (e.g., highly requested rooms in small hotels) to validate HTTP `409 Conflict` handling in the backend.
* **Weighted Roulette Wheel Selection:** Employs a custom probability algorithm to select user personas based on defined weights, simulating diverse user bases.
* **Cancellation Chaos:** Evaluates a `cancelProbability` after a successful booking (`201 Created`). If triggered, the Goroutine asynchronously sends a `DELETE` request after a random delay, forcing the backend to handle dynamic resource freeing.
* **Traffic Shaping:** Implements randomized micro-delays (`time.Sleep`) between requests to mimic organic, unpredictable user traffic rather than a static bot attack.

## 🏗️ Architecture & Tech Stack

* **Simulation Engine (Frontend):** Go (Golang)
* **Backend:** Java Spring Boot, REST API
* **Database:** PostgreSQL (Strict ACID compliance testing)

## ⚙️ Configuration (Data-Driven Design)

The engine's behavior is entirely decoupled from the code and controlled via two JSON files:

### `hotels.json`
Acts as the knowledge base for the Go engine, mirroring the master data in the PostgreSQL database. It defines the constraints (e.g., maximum room capacities) necessary for generating valid requests.

### `personas.json`
Defines the behavior of the simulated users. Each persona includes:
* `weight`: The probability of this persona being selected for a booking request.
* `minStayDays` / `maxStayDays`: Used to calculate a randomized, valid checkout date.
* `preferredHotels`: An array of hotel IDs this persona wants to book.
* `cancelProbability`: A float representing the chance (0.0 to 1.0) that this persona will cancel their booking shortly after making it.

## 🚦 How It Works (The Simulation Loop)

For a defined number of iterations (e.g., 1,000 requests), the engine performs the following lifecycle:
1. Picks a persona via Roulette Wheel Selection.
2. Selects a preferred hotel and generates a random room number and valid date range.
3. Fires an asynchronous `POST /book` request.
4. Reads the returned PostgreSQL ID from the response.
5. Rolls the dice against the persona's `cancelProbability`.
6. If the persona decides to cancel, waits a few seconds and fires a `DELETE /cancel/{id}` request.

## 💻 Running the Engine

Make sure your Spring Boot backend and PostgreSQL database are up and running.
Navigate to the Go project directory and execute:

```bash
go run .