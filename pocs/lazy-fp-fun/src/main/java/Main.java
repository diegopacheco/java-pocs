
public class Main {
    // Book and Order are highly coupled to each other.
    // However, both can be constructed in an atomic way, without temporal coupling
    // To do so we need a third object and a bit of functional programing
    //
    // A Builder would solve the problem with more simplicity
    // 
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
