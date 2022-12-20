package com.example.mob_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private Integer IdBook;
    private String TitleBook;
    private String Annotation;
    private String Summary;
    private String Image;
    private String NameAuthor;
    private String TitleGenre;

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

    public Book(Integer idBook, String titleBook, String annotation, String summary, String image, String author, String genre) {
        IdBook = idBook;
        TitleBook = titleBook;
        Annotation = annotation;
        Summary = summary;
        Image = image;
        NameAuthor = author;
        TitleGenre = genre;
    }

    protected Book(Parcel in) {
        IdBook = in.readInt();
        TitleBook = in.readString();
        Annotation = in.readString();
        Summary = in.readString();
        Image = in.readString();
        NameAuthor = in.readString();
        TitleGenre = in.readString();
    }

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
        parcel.writeString(NameAuthor);
        parcel.writeString(TitleGenre);
    }

    public Integer getIdBook() {
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

    public String getNameAuthor() {
        return NameAuthor;
    }

    public String getTitleGenre() {
        return TitleGenre;
    }

    public void setIdBook(Integer idBook) {
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

    public void setNameAuthor(String nameAuthor) {
        NameAuthor = nameAuthor;
    }

    public void setTitleGenre(String titleGenre) {
        TitleGenre = titleGenre;
    }
}
