package com.example.mob_books;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private Adapter pAdapter;
    private List<Book> listBooks = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ivProducts = findViewById(R.id.ListBook);
        pAdapter = new Adapter(MainActivity.this, listBooks);
        ivProducts.setAdapter(pAdapter);
        new Get().execute();
    }

    class Get extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... voids) {
            try
            {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/БорисоваЕА/api/Table_Books");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String str = "";
                while ((str = reader.readLine()) != null) {
                    result.append(str);
                }
                return result.toString();
            }
            catch (Exception exception)
            {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try
            {
                //listBooks.clear();
                JSONArray tempArray = new JSONArray(s);
                for (int i = 0; i<tempArray.length(); i++)
                {
                    JSONObject productJson = tempArray.getJSONObject(i);
                    Book tempBook = new Book(
                            productJson.getInt("IdBook"),
                            productJson.getString("TitleBook"),
                            productJson.getString("Annitation"),
                            productJson.getString("Summary"),
                            productJson.getString("Image"),
                            productJson.getString("Author"),
                            productJson.getString("Genre")
                    );
                    listBooks.add(tempBook);
                    pAdapter.notifyDataSetInvalidated();
                }
            } catch (Exception ignored) {
            }
         }
    }

}