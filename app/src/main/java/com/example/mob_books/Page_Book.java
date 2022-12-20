package com.example.mob_books;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Page_Book extends AppCompatActivity {

    TextInputEditText TitleBook, Author, Genre;
    TextView Annotation, Links;
    ImageView Image;
    View v;
    Bundle arg;
    Book book;
    Bitmap bitmap=null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_book);

        arg = getIntent().getExtras();
        book = arg.getParcelable(Book.class.getSimpleName());

        TitleBook = findViewById(R.id.title1);
        Author = findViewById(R.id.author1);
        Genre = findViewById(R.id.genre1);
        Annotation = findViewById(R.id.tv_Annotation);
        Image = findViewById(R.id.imageView);

        TitleBook.setText(book.getTitleBook());
        Author.setText(book.getAuthor());
        Genre.setText(book.getGenre());
        Annotation.setText(book.getAnnitation());

        DecodeImg decodeImage = new DecodeImg(Page_Book.this);
        Bitmap userImage = decodeImage.getUserImage(book.getImage());
        Image.setImageBitmap(userImage);
        if(!book.getImage().equals("null")){
            bitmap = userImage;
        }
    }

    public void onClickBack(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickRead(View v)
    {
        Intent intent = new Intent(this, Page_Read.class);
        startActivity(intent);

    }
}