package main

type Persona struct {
	Id                string  `json:"id"`
	Name              string  `json:"name"`
	Weight            int     `json:"weight"`
	MinStayDays       int     `json:"minStayDays"`
	MaxStayDays       int     `json:"maxStayDays"`
	PreferredHotels   []int   `json:"preferredHotels"`
	CancelProbability float64 `json:"cancelProbability"`
}