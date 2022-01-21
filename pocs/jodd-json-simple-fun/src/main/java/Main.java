import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

public class Main {
    public static void main(String args[]) {
        Movie m = new Movie();
        m.setGenre("Action");
        m.setTitle("Big Trouble in Little China");
        m.setStars(5);

        String json = JsonSerializer.create()
                .serialize(m);
        System.out.println(json);

        Movie m2 = new JsonParser().parse(json, Movie.class);
        System.out.println(m2);
    }
}
