package test.quantox.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.quantox.movies.model.MovieList;

import static test.quantox.movies.Constants.API_KEY;
import static test.quantox.movies.Constants.BASE_URL;

public class TopListFragment extends Fragment implements Callback<MovieList> {

    public static final int TOP_RATED = 0, POPULAR = 1;
    private static final String KEY_TYPE = "type";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public static TopListFragment newInstance(int type) {
        TopListFragment fragment = new TopListFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkApi networkApi = retrofit.create(NetworkApi.class);
        int type = getArguments().getInt(KEY_TYPE);
        if (type == TOP_RATED) {
            networkApi.getTopRatedMovies(API_KEY).enqueue(this);
        } else if (type == POPULAR) {
            networkApi.getPopularMovies(API_KEY).enqueue(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = view.findViewById(R.id.progressBar);
        return view;
    }

    @Override
    public void onResponse(Call<MovieList> call, Response<MovieList> response) {
        MovieList movieList = response.body();
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(new MovieAdapter(movieList.getMovies(), getActivity()));
    }

    @Override
    public void onFailure(Call<MovieList> call, Throwable t) {
        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
    }
}
