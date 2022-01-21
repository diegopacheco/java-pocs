import java.util.Objects;

public class Movie {

    private String title;
    private String genre;
    private Integer stars;

    public Movie(){}

    public Movie(String title, String genre, Integer stars) {
        this.title = title;
        this.genre = genre;
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getStars() {
        return stars;
    }
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre) && Objects.equals(stars, movie.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, stars);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", stars=" + stars +
                '}';
    }
}
