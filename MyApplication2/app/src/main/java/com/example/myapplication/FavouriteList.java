package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FavouriteList extends AppCompatActivity {
    RecyclerView mylist_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Your Favourites");
        myToolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        int[] temp = getIntent().getIntArrayExtra("index");
        if(temp.length!= 0){
            String[] data = getIntent().getStringArrayExtra("data");
            boolean[] isFavourite = getIntent().getBooleanArrayExtra("isFavourite");
            mylist_name = (RecyclerView) findViewById(R.id.myList);
            mylist_name.setLayoutManager(new LinearLayoutManager(FavouriteList.this));
            MyAdapter adapter = new MyAdapter(data, isFavourite, false);
            adapter.onClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = mylist_name.getChildAdapterPosition(v);
                    ItemListDialogFragment.newInstance(position, data[position], temp).show(getSupportFragmentManager(), "dialog");
                }
            });
            mylist_name.setAdapter(adapter);
        }
        else
        {
            TextView myText = (TextView) findViewById(R.id.textView4);
            myText.setText("Nothing To Show!");
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}