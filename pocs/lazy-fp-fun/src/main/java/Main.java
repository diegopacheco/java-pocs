
public class Main {
    public static void main(String args[]) {
        final var book = new Lazy<Book>(bookRef -> {
            final var order = new Lazy<>(() -> new Order(bookRef, "en"));
            return new Book(order, 5);
        }).value();
        final var order = book.order();
        System.out.println(order);
        System.out.println(order.book());
    }
}
