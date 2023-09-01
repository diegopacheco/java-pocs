package main

import (
	"fmt"
	"net/http"

	"github.com/google/uuid"
)

func handler(w http.ResponseWriter, r *http.Request) {
	uuid := uuid.New()
	fmt.Fprintf(w, uuid.String())
}

func main() {
	fmt.Printf("Go net/http running on 8080 \n")
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}
