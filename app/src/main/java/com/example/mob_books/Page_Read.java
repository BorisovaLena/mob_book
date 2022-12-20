package com.example.mob_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page_Read extends AppCompatActivity {

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