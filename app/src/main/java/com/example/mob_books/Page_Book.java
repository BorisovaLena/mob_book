package com.example.mob_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Page_Book extends AppCompatActivity {

    EditText TitleBook, NameAuthor, TitleGenre;
    TextView Annotation, Links;
    ImageView Image;

    Bundle arg;
    Book book;
    Bitmap bitmap=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_book);

        arg = getIntent().getExtras();
        book = arg.getParcelable(Book.class.getSimpleName());
        TitleBook = findViewById(R.id.title);
        NameAuthor = findViewById(R.id.author);
        TitleGenre = findViewById(R.id.genre);
        Annotation = findViewById(R.id.tv_Annotation);
        Links = findViewById(R.id.tv_Links);

        DecodeImg decodeImage = new DecodeImg(Page_Book.this);
        Bitmap userImage = decodeImage.getUserImage(book.getImage());
        Image.setImageBitmap(userImage);
        if(!book.getImage().equals("null")){
            bitmap = userImage;
        }
    }

    public void onClickRead(View v)
    {
        Intent intent = new Intent(this, Page_Read.class);
        startActivity(intent);
    }
}