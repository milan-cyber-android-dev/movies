package test.quantox.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieList {

    @SerializedName("results")
    @Expose
    Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }
}
