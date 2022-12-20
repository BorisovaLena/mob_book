package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Link implements Parcelable {

    private Integer IdLink;
    private String Link;
    private int IdBook;

    public Link(Integer idLink, String link, Integer idBook)
    {
        IdLink = idLink;
        Link = link;
        IdBook = idBook;
    }

    protected Link(Parcel in) {
        IdLink = in.readInt();
        Link = in.readString();
        IdBook = in.readInt();
    }

    public static final Creator<Link> CREATOR = new Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(IdLink);
        parcel.writeString(Link);
        parcel.writeInt(IdBook);
    }

    public Integer getIdLink() {
        return IdLink;
    }

    public String getLink() {
        return Link;
    }

    public int getIdBook() {
        return IdBook;
    }

    public void setIdLink(Integer idLink) {
        IdLink = idLink;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setIdBook(int idBook) {
        IdBook = idBook;
    }
}
