package com.example.mymoviecatalog.Class;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {

    private String name_tvshow;
    private String description_tvshow;
    private int photo_tvshow;
    private String runtime_tvshow;
    private String releasedate_tvshow;

    public String getName_tvshow() {
        return name_tvshow;
    }

    public void setName_tvshow(String name_tvshow) {
        this.name_tvshow = name_tvshow;
    }

    public String getDescription_tvshow() {
        return description_tvshow;
    }

    public void setDescription_tvshow(String description_tvshow) {
        this.description_tvshow = description_tvshow;
    }

    public int getPhoto_tvshow() {
        return photo_tvshow;
    }

    public void setPhoto_tvshow(int photo_tvshow) {
        this.photo_tvshow = photo_tvshow;
    }

    public String getRuntime_tvshow() {
        return runtime_tvshow;
    }

    public void setRuntime_tvshow(String runtime_tvshow) {
        this.runtime_tvshow = runtime_tvshow;
    }

    public String getReleasedate_tvshow() {
        return releasedate_tvshow;
    }

    public void setReleasedate_tvshow(String releasedate_tvshow) {
        this.releasedate_tvshow = releasedate_tvshow;
    }

    public TVShow(Parcel in) {
        name_tvshow = in.readString();
        description_tvshow = in.readString();
        photo_tvshow = in.readInt();
        runtime_tvshow = in.readString();
        releasedate_tvshow = in.readString();
    }

    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_tvshow);
        dest.writeString(description_tvshow);
        dest.writeInt(photo_tvshow);
        dest.writeString(runtime_tvshow);
        dest.writeString(releasedate_tvshow);
    }


    public TVShow() {
    }

}
