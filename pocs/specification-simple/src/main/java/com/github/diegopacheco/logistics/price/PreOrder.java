package com.github.diegopacheco.logistics.price;

import com.github.diegopacheco.logistics.price.specification.State;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class PreOrder {

    private Priority priority;
    private Set<Item> items;
    private int destinationZipcode;
    private State destinationState;

    public PreOrder(Priority priority, Set<Item> items, int destinationZipcode, State destinationState) {
        this.priority = priority;
        this.items = items;
        this.destinationZipcode = destinationZipcode;
        this.destinationState = destinationState;
    }

    public BigDecimal getTotal(){
        return BigDecimal.valueOf(items.
                stream().
                mapToInt(ob ->(ob.getQuantity()+ob.quantity)).
                reduce(0, (a,b)->a+b));
    }

    public enum Priority{
        HIGH,
        MEDIUM,
        LOW
    }

    public static class Item{
        private String name;
        private int quantity;
        private int weight;

        public Item(String name, int quantity, int weight) {
            this.name = name;
            this.quantity = quantity;
            this.weight = weight;
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

    public Priority getPriority() {
        return priority;
    }

    public Set<Item> getItems() {
        return items;
    }

    public int getDestinationZipcode() {
        return destinationZipcode;
    }

    public State getDestinationState() {
        return destinationState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreOrder preOrder = (PreOrder) o;
        return destinationZipcode == preOrder.destinationZipcode && priority == preOrder.priority && Objects.equals(items, preOrder.items) && destinationState == preOrder.destinationState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, items, destinationZipcode, destinationState);
    }

    @Override
    public String toString() {
        return "PreOrder{" +
                "priority=" + priority +
                ", items=" + items +
                ", destinationZipcode=" + destinationZipcode +
                ", destinationState=" + destinationState +
                '}';
    }
}
