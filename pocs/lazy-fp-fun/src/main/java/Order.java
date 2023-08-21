public class Order {
    private final Lazy<Book> book;
    private final Lazy<Integer> total;
    private final String language;

    public Order(Lazy<Book> book, String language) {
        this.book = book;
        this.total = book.map(x -> x.price() + 10);
        this.language = language;
    }

    public Book book() {
        return book.value();
    }

    public String language() {
        return language;
    }

    public int total() {
        return total.value();
    }

    @Override
    public String toString() {
        return "Order{" +
                "book=" + book+
                ", total=" + total +
                ", language='" + language + '\'' +
                '}';
    }
}
