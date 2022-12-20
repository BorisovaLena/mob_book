package com.example.mob_books;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public class Page_Book extends AppCompatActivity {

    TextInputEditText TitleBook, Author, Genre;
    TextView Annotation, Links;
    ImageView Image;
    Bundle arg;
    Book book;

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
        Links = findViewById(R.id.tv_Links);

        TitleBook.setText(book.getTitleBook());
        Author.setText(book.getAuthor());
        Genre.setText(book.getGenre());
        Annotation.setText(book.getAnnitation());

        DecodeImg decodeImage = new DecodeImg(Page_Book.this);
        Image.setImageBitmap(decodeImage.getUserImage(book.getImage()));
    }

    public void onClickBack(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickRead(View v)
    {
        Intent intent = new Intent(this, Page_Read.class);
        intent.putExtra(Book.class.getSimpleName(), book);
        startActivity(intent);

    }
}