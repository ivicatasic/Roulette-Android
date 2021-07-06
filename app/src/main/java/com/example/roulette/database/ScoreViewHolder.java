package com.example.roulette.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roulette.R;

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    private  final TextView textView;

    public ScoreViewHolder(@NonNull View itemView) {

        super(itemView);
        textView=itemView.findViewById(R.id.textView);

    }

    public void bind(final String text){
        textView.setText(text);
    }

    static ScoreViewHolder create(final ViewGroup parent){
        final View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleview_item,parent,false);
        return  new ScoreViewHolder(view);
    }
}
