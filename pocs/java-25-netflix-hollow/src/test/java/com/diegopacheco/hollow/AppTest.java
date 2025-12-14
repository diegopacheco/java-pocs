package com.diegopacheco.hollow;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
  @Test
  void roundTripStoresMovies() throws Exception {
    List<Movie> input = List.of(
        new Movie(10, "Arrival", 2016),
        new Movie(11, "Memento", 2000)
    );
    List<Movie> stored = App.roundTrip(input);
    assertEquals(input.size(), stored.size());
    assertTrue(stored.containsAll(input));
  }
}
