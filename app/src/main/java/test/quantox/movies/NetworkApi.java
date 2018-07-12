package test.quantox.movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.quantox.movies.model.MovieList;

public interface NetworkApi {

    @GET("movie/top_rated")
    Call<MovieList> getTopRatedMovies(@Query(value = "api_key") String apiKey);

    @GET("movie/popular")
    Call<MovieList> getPopularMovies(@Query(value = "api_key") String apiKey);
}
