package main

import (
	"context"
	"fmt"
	"log"
	"os"
	"os/signal"
	"syscall"
	"github.com/segmentio/kafka-go"
)

func main() {
	brokers := []string{"kafka:9092"}
	topic := "dbserver1.public.data_events"

	reader := kafka.NewReader(kafka.ReaderConfig{
		Brokers:  brokers,
		Topic:    topic,
		GroupID:  "go-consumer-group",
		MinBytes: 10e3,
		MaxBytes: 10e6,
	})
	defer reader.Close()

	log.Printf("Go consumer started - reading from topic: %s", topic)

	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	sigchan := make(chan os.Signal, 1)
	signal.Notify(sigchan, syscall.SIGINT, syscall.SIGTERM)

	go func() {
		<-sigchan
		log.Println("Shutting down consumer...")
		cancel()
	}()

	for {
		select {
		case <-ctx.Done():
			return
		default:
			msg, err := reader.ReadMessage(ctx)
			if err != nil {
				if err == context.Canceled {
					return
				}
				log.Printf("Error reading message: %v", err)
				continue
			}
			fmt.Printf("Received CDC Event - Partition: %d, Offset: %d, Key: %s, Value: %s\n",
				msg.Partition, msg.Offset, string(msg.Key), string(msg.Value))
		}
	}
}
