package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {

    private Integer IdGenre;
    private String TitleGenre;

    public Genre(Integer idGenre, String titleGenre)
    {
        IdGenre = idGenre;
        TitleGenre = titleGenre;
    }

    protected Genre(Parcel in) {
        IdGenre = in.readInt();
        TitleGenre = in.readString();
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(IdGenre);
        parcel.writeString(TitleGenre);
    }

    public Integer getIdGenre() {
        return IdGenre;
    }

    public String getTitleGenre() {
        return TitleGenre;
    }

    public void setIdGenre(Integer idGenre) {
        IdGenre = idGenre;
    }

    public void setTitleGenre(String titleGenre) {
        TitleGenre = titleGenre;
    }
}
