package com.example.mob_books;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter pAdapter;
    private final List<Book> listBooks = new ArrayList<>();
    ListView lvBooks;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvBooks = findViewById(R.id.BD_Books);

        ListView ivProducts = findViewById(R.id.BD_Books);
        pAdapter = new Adapter(MainActivity.this, listBooks);
        ivProducts.setAdapter(pAdapter);
        new GetAnim();
    }

    class GetAnim extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... voids) {
            try
            {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/api/Table_Books");
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
                listBooks.clear();
                JSONArray tempArray = new JSONArray(s);
                for (int i = 0;i<tempArray.length();i++)
                {
                    JSONObject productJson = tempArray.getJSONObject(i);
                    Book tempAnimal = new Book(
                            productJson.getInt("IdBook"),
                            productJson.getString("TitleBook"),
                            productJson.getString("Annotation"),
                            productJson.getString("Summary"),
                            productJson.getString("Image"),
                            productJson.getInt("IdAuthor"),
                            productJson.getInt("IdGenre")
                    );
                    listBooks.add(tempAnimal);
                    pAdapter.notifyDataSetInvalidated();
                }
            } catch (Exception ignored) {
            }
         }
    }

}