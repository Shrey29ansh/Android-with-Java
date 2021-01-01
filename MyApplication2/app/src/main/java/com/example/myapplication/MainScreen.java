package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainScreen extends AppCompatActivity {
    RecyclerView list_name;
    MyAdapter adapter;
    public static String[] data  ={"C++", "Python", "C", "JAVA", "Ruby", "Javascript"};
    public static boolean[] isFavourite = {false,false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        list_name = (RecyclerView) findViewById(R.id.mainList);
        list_name.setLayoutManager(new LinearLayoutManager(MainScreen.this));
        adapter = new MyAdapter(data,isFavourite);
        adapter.onClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = list_name.getChildAdapterPosition(v);
                ItemListDialogFragment.newInstance(position,data[position]).show(getSupportFragmentManager(), "dialog");
            }
        });
        list_name.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item3:
                ArrayList<Integer> temp3= new ArrayList<Integer>();
                ArrayList<String> temp= new ArrayList<String>();
                for (int i =0;i<adapter.isFavourite.length;i++)
                {
                    if(adapter.isFavourite[i]) {
                        temp.add(data[i]);
                        temp3.add(i);
                    }
                }
                boolean[] isFinal =new boolean[temp.size()];
                String[] isData =new String[temp.size()];
                int[] myTemp = new int[temp3.size()];
                for(int j =0;j<temp.size();j++){
                    isData[j] = temp.get(j);
                    myTemp[j] = temp3.get(j);
                    isFinal[j] =true;
                }
                Intent intent = new Intent(MainScreen.this, FavouriteList.class);
                intent.putExtra("isFavourite",isFinal);
                intent.putExtra("data",isData);
                intent.putExtra("index", myTemp);
                startActivity(intent);
                //overridePendingTransition(R.anim.slide_in_left,R.anim.exit);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}