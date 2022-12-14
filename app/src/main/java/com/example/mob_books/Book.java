package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private int IdBook;
    private String TitleBook;
    private String Annotation;
    private String Summary;
    private String Image;
    private int IdAuthor;
    private int IdGenre;

    protected Book(Parcel in) {
        IdBook = in.readInt();
        TitleBook = in.readString();
        Annotation = in.readString();
        Summary = in.readString();
        Image = in.readString();
        IdAuthor = in.readInt();
        IdGenre = in.readInt();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdBook);
        parcel.writeString(TitleBook);
        parcel.writeString(Annotation);
        parcel.writeString(Summary);
        parcel.writeString(Image);
        parcel.writeInt(IdAuthor);
        parcel.writeInt(IdGenre);
    }

    public int getIdBook() {
        return IdBook;
    }

    public String getTitleBook() {
        return TitleBook;
    }

    public String getAnnotation() {
        return Annotation;
    }

    public String getSummary() {
        return Summary;
    }

    public String getImage() {
        return Image;
    }

    public int getIdAuthor() {
        return IdAuthor;
    }

    public int getIdGenre() {
        return IdGenre;
    }

    public void setIdBook(int idBook) {
        IdBook = idBook;
    }

    public void setTitleBook(String titleBook) {
        TitleBook = titleBook;
    }

    public void setAnnotation(String annotation) {
        Annotation = annotation;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setIdAuthor(int idAuthor) {
        IdAuthor = idAuthor;
    }

    public void setIdGenre(int idGenre) {
        IdGenre = idGenre;
    }
}
