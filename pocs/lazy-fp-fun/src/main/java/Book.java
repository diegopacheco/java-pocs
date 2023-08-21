
public class Book {
    private final Lazy<Order> order;
    private final Lazy<String> language;
    private final int price;

    public Book(Lazy<Order> order, int price) {
        this.order = order;
        this.language = order.map(Order::language);
        this.price = price;
    }

    public Order order() {
        return order.value();
    }

    public int price() {
        return price;
    }

    public String language() {
        return language.value();
    }

    @Override
    public String toString() {
        return "Book{" +
                "order=" + order +
                ", language=" + language +
                ", price=" + price +
                '}';
    }
}
