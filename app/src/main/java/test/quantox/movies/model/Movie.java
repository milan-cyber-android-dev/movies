package test.quantox.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("title")
    @Expose
    String name;
    @SerializedName("poster_path")
    @Expose
    String imageUrl;
    @SerializedName("vote_average")
    @Expose
    double rating;
    @SerializedName("overview")
    @Expose
    String description;

    protected Movie(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageUrl = in.readString();
        rating = in.readDouble();
        description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeDouble(rating);
        dest.writeString(description);
    }
}
