package com.example.roulette.database;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ScoreListAdapter extends ListAdapter<Score,ScoreViewHolder> {


    public ScoreListAdapter(@NonNull final DiffUtil.ItemCallback<Score> diffCallback){
        super(diffCallback);
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ScoreViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        final Score currScore=getItem(position);
        holder.bind(currScore.getName());
    }

    public static class ScoreDiffCallBack extends DiffUtil.ItemCallback<Score>{

        @Override
        public boolean areItemsTheSame(@NonNull Score oldItem, @NonNull Score newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Score oldItem, @NonNull Score newItem) {
            return  oldItem.getName().equals(newItem.getName());
        }
    }

}
