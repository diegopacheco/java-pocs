package com.github.diegopacheco.sandbox.scala.ribbon.fun.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recommendations {
    private static final Pattern FORMAT_RE = Pattern.compile("\\{movies=\\[(\\{[^\\}]*\\})?(, \\{[^\\}]*\\})*\\]\\}");

    private final List<Movie> movies;

    public Recommendations(List<Movie> movies) {
        this.movies = Collections.unmodifiableList(movies);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recommendations that = (Recommendations) o;

        if (movies != null ? !movies.equals(that.movies) : that.movies != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return movies != null ? movies.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{movies=" + movies + '}';
    }

    public static Recommendations from(String formatted) {
        Matcher matcher = FORMAT_RE.matcher(formatted);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Syntax error in recommendations string: " + formatted);
        }
        List<Movie> movies = new ArrayList<Movie>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            String movie = matcher.group(i);
            if (movie.startsWith(",")) {
                movie = movie.substring(1).trim();
            }
            movies.add(Movie.from(movie));
        }
        return new Recommendations(movies);
    }
}