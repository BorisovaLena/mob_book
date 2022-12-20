package com.example.mob_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Page_Read extends AppCompatActivity {
    Bundle arg;
    Book book;
    TextView TitleBook, Summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_read);

    }

    public void onClickBook(View v)
    {
        Intent intent = new Intent(this, Page_Book.class);
        startActivity(intent);
    }
}