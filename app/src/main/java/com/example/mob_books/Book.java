package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private Integer IdBook;
    private String TitleBook;
    private String Annitation;
    private String Summary;
    private String Image;
    private String Author;
    private String Genre;

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book(Integer idBook, String titleBook, String annotation, String summary, String image, String nameAuthor, String titleGenre) {
        IdBook = idBook;
        TitleBook = titleBook;
        Annitation = annotation;
        Summary = summary;
        Image = image;
        Author = nameAuthor;
        Genre = titleGenre;
    }

    protected Book(Parcel in) {
        IdBook = in.readInt();
        TitleBook = in.readString();
        Annitation = in.readString();
        Summary = in.readString();
        Image = in.readString();
        Author = in.readString();
        Genre = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdBook);
        parcel.writeString(TitleBook);
        parcel.writeString(Annitation);
        parcel.writeString(Summary);
        parcel.writeString(Image);
        parcel.writeString(Author);
        parcel.writeString(Genre);
    }

    public Integer getIdBook() {
        return IdBook;
    }

    public String getTitleBook() {
        return TitleBook;
    }

    public String getAnnitation() {
        return Annitation;
    }

    public String getSummary() {
        return Summary;
    }

    public String getImage() {
        return Image;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setIdBook(Integer idBook) {
        IdBook = idBook;
    }

    public void setTitleBook(String titleBook) {
        TitleBook = titleBook;
    }

    public void setAnnitation(String annitation) {
        Annitation = annitation;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }
}
