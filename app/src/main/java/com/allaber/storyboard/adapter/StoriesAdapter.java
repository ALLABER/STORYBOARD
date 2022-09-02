package com.allaber.storyboard.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.allaber.storyboard.R;
import com.allaber.storyboard.utils.api.models.Story;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter< StoriesAdapter.ViewHolder> {

    private List<Story> mStories;
    private Context mContext;

    public StoriesAdapter(List<Story> stories) {
        this.mStories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View contactView = inflater.inflate(R.layout.item_stories, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = mStories.get(position);

        CardView cardViewItem = holder.cardViewItem;
        cardViewItem.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(story.getUrl()));
            mContext.startActivity(browserIntent);
        });


        ImageView imageViewPreview = holder.imageViewPreview;
        Picasso.get()
                .load(story.getImage_logo())
                .placeholder(R.drawable.news_placeholder)
                .into(imageViewPreview);

        TextView textViewNewsName = holder.textViewNewsPreview;
        textViewNewsName.setText(story.getNews_name());


        TextView textViewNewsDate = holder.textViewNewsDate;
        textViewNewsDate.setText(story.getDate());
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardViewItem;
        public ImageView imageViewPreview;
        public TextView textViewNewsPreview;
        public TextView textViewNewsDate;

        public ViewHolder(View itemView) {
            super(itemView);

            cardViewItem = itemView.findViewById(R.id.cardViewItem);
            imageViewPreview = itemView.findViewById(R.id.imageViewPreview);
            textViewNewsPreview = itemView.findViewById(R.id.textViewNewsPreview);
            textViewNewsDate = itemView.findViewById(R.id.textViewNewsDate);
        }
    }
}