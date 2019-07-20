package com.example.mymoviecatalog.Class;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String name;
    private String description;
    private int photo;
    private String runtime;
    private String releasedate;

    public String getReleasedate() { return releasedate; }

    public void setReleasedate(String releasedate) { this.releasedate = releasedate; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getRuntime() { return runtime; }

    public void setRuntime(String runtime) { this.runtime = runtime; }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.runtime);
        dest.writeString(this.releasedate);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.runtime = in.readString();
        this.releasedate= in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
