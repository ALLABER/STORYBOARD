package com.allaber.storyboard.viewmodels.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.allaber.storyboard.BR;
import com.allaber.storyboard.R;
import com.allaber.storyboard.databinding.ItemStoriesBinding;
import com.allaber.storyboard.models.StoriesModel;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter< StoriesAdapter.ViewHolder> implements StoriesClickListener{

    private List<StoriesModel> stories;
    private Context context;

    public StoriesAdapter(List<StoriesModel> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStoriesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_stories, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StoriesModel story = stories.get(position);

        holder.bind(story);
        holder.itemRowBinding.setStoriesClickListener(this);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemStoriesBinding itemRowBinding;

        public ViewHolder(ItemStoriesBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object object) {
            itemRowBinding.setVariable(BR.model, object);
            itemRowBinding.executePendingBindings();
        }
    }

    @Override
    public void cardClicked(StoriesModel storiesModel) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storiesModel.getStoriesLink()));
        browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(browserIntent);
    }
}