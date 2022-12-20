package com.example.mob_books;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import java.io.InputStream;

import javax.security.auth.callback.Callback;

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

    public void AddPhoto(View v){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pickImg.launch(intent);
    }

    private final ActivityResultLauncher<Intent> pickImg = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            if (result.getData() != null) {
                Uri uri = result.getData().getData();
                try {
                    InputStream is = getContentResolver().openInputStream(uri);
                    bitmap = BitmapFactory.decodeStream(is);
                    Image.setImageURI(uri);
                } catch (Exception e) {
                    Log.e(e.toString(), e.getMessage());
                }
            }
        }
    });

    public void UpdateAnimal(View v)
    {
        try{
            EncodeImg EI = new EncodeImg();
            book.setImage(EI.Image(bitmap));
            put(book, v);
            SystemClock.sleep(1000);
            onClickBack(v);

        }
        catch (Exception ex)
        {
            Toast.makeText(Page_Book.this, "Косяк!", Toast.LENGTH_SHORT).show();
        }
    }

    private void put(Book book, View v)
    {


    }
}