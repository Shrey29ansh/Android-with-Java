package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterHolder> implements OnClickListener {
    private final String[] data;
    final boolean[] isFavourite;
    int img;
    OnClickListener onClickListener;
    boolean screen =true;
    public MyAdapter(String[] data,boolean[] isFavourite){
        this.data = data;
        this.isFavourite =isFavourite;
    }
    public MyAdapter(String[] data,boolean[] isFavourite,boolean screen){
        this.screen = screen;
        this.data = data;
        this.isFavourite =isFavourite;
    }

    @NonNull
    @Override
    public MyAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent,false);
        view.setOnClickListener(this);
        return new MyAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterHolder holder, int position) {
        String title = data[position];
        String firstLetter = String.valueOf(data[position].charAt(0));
        img = R.drawable.ic_baseline_favorite_border_24;
        if(isFavourite[position])
            img = R.drawable.ic_baseline_favourite_24;
        holder.txtTitle.setText(title);
        holder.letterFirst.setText(firstLetter);
        if(screen) {
            holder.imageButton.setImageResource(img);
            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isFavourite[position] = !isFavourite[position];
                    if (isFavourite[position])
                        holder.imageButton.setImageResource(R.drawable.ic_baseline_favourite_24);
                    else
                        holder.imageButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    public boolean onClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
        return true;
    }
    @Override
    public void onClick(View v) {
        onClickListener.onClick(v);
        return ;
    }

    public static class MyAdapterHolder extends RecyclerView.ViewHolder {
        TextView letterFirst;
        TextView txtTitle;
        ImageButton imageButton;
        public MyAdapterHolder(@NonNull View itemView) {
            super(itemView);
            letterFirst = itemView.findViewById(R.id.textView2);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imageButton = itemView.findViewById(R.id.imageButton2);
        }

    }
}
