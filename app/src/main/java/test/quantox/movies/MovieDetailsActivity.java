package test.quantox.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import test.quantox.movies.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "test.quantox.movies.MOVIE";

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        setTitle(movie.getName());
        TextView name = findViewById(R.id.name);
        name.setText(movie.getName());
        TextView description = findViewById(R.id.description);
        description.setText(movie.getDescription());
        ImageView movieImage = findViewById(R.id.movieImage);
        Glide.with(movieImage).load(Constants.BASE_IMAGE_URL + movie.getImageUrl()).into(movieImage);
    }
}
