package com.github.diegopacheco.logistics.price;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Order {

    private UUID id;
    private Priority priority;
    private Set<Item> items;
    private int destinationZipcode;

    public Order(UUID id, Priority priority, Set<Item> items, int destinationZipcode) {
        this.id = id;
        this.priority = priority;
        this.items = items;
        this.destinationZipcode = destinationZipcode;
    }

    public Order(Priority priority, Set<Item> items, int destinationZipcode) {
        this(UUID.randomUUID(),priority,items,destinationZipcode);
    }

    enum Priority{
        HIGH,
        MEDIUM,
        LOW
    }

    class Item{
        private UUID id;
        private String name;
        private int quantity;
        private int weight;

        public Item(UUID id, String name, int quantity, int weight) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.weight = weight;
        }

        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getWeight() {
            return weight;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", priority=" + priority +
                ", items=" + items +
                ", destinationZipcode=" + destinationZipcode +
                '}';
    }
}
