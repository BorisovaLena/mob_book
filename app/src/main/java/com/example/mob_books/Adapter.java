package com.example.mob_books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private final Context mContext;
    List<Book> bookList;

    public Adapter(Context mContext, List<Book> bookList) {
        this.mContext = mContext;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookList.get(position).getIdBook();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        @SuppressLint("ViewHolder") View v = View.inflate(mContext, R.layout.item_book,null);
        TextView TitleBook = v.findViewById(R.id.tv_TitleBook);
        TextView Author = v.findViewById(R.id.tv_Author);
        TextView Genre = v.findViewById(R.id.tv_Genre);
        ImageView Image = v.findViewById(R.id.Img);
        Book book = bookList.get(position);
        TitleBook.setText(book.getTitleBook());
        Author.setText(book.getAuthor());
        Genre.setText(book.getGenre());
        DecodeImg DI = new DecodeImg(mContext);
        Image.setImageBitmap(DI.getUserImage(book.getImage()));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Page_Book.class);
                intent.putExtra(Book.class.getSimpleName(), book);
                mContext.startActivity(intent);
            }
        });
        return v;
    }
}
