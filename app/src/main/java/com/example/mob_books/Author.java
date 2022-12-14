package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Author implements Parcelable {

    private int IdAuthor;
    private String Author;

    protected Author(Parcel in) {
        IdAuthor = in.readInt();
        Author = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(IdAuthor);
        parcel.writeString(Author);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    public int getIdAuthor() {
        return IdAuthor;
    }

    public String getAuthor() {
        return Author;
    }

    public void setIdAuthor(int idAuthor) {
        IdAuthor = idAuthor;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
