package com.diegopacheco.hollow;

import java.util.Objects;

public class Movie {
  private final int id;
  private final String title;
  private final int year;

  public Movie(int id, String title, int year) {
    this.id = id;
    this.title = title;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Movie movie = (Movie) other;
    return id == movie.id && year == movie.year && Objects.equals(title, movie.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, year);
  }

  @Override
  public String toString() {
    return id + " - " + title + " (" + year + ")";
  }
}
