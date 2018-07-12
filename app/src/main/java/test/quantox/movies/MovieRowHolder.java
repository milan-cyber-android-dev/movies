package test.quantox.movies;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import test.quantox.movies.model.Movie;

public class MovieRowHolder extends RecyclerView.ViewHolder {

    ImageView movieImage;
    TextView name, genre, rating;
    View rootView;

    public MovieRowHolder(View itemView) {
        super(itemView);
        movieImage = itemView.findViewById(R.id.movieImage);
        name = itemView.findViewById(R.id.name);
        genre = itemView.findViewById(R.id.genre);
        rating = itemView.findViewById(R.id.rating);
        rootView = itemView;
    }

    void bindView(final Movie movie) {
        name.setText(movie.getName());
        rating.setText(String.valueOf(movie.getRating()));
        Glide.with(movieImage).load(Constants.BASE_IMAGE_URL + movie.getImageUrl()).into(movieImage);
        genre.setText("Drama");
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(), MovieDetailsActivity.class);
                intent.putExtra(MovieDetailsActivity.EXTRA_MOVIE, movie);
                rootView.getContext().startActivity(intent);
            }
        });
    }
}
