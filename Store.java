import java.util.Arrays;

public class Store {
    private Movie[] movies;

    public Store (Movie[] movies) {
        this.movies = new Movie[10];
        for (int i = 0; i < movies.length; i++) {
        this.movies[i] = new Movie(movies[i]);
        }
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies[index]);
    }

    public Movie[] getAllMovie() {
        return Arrays.copyOf(this.movies, this.movies.length);
    }

    public void setMovie(int index, Movie movie) {
        this.movies[index] = new Movie(movie);
    }

    public void setRatingInStore (int index, double rating) {
        this.movies[index].setRating(rating);
    }
}
