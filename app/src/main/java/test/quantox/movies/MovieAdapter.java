package test.quantox.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.quantox.movies.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieRowHolder> {

    Movie[] movies;
    Context context;

    public MovieAdapter(Movie[] movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRowHolder holder, int position) {
        holder.bindView(movies[position]);
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }
}
