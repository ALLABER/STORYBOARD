package com.allaber.storyboard.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailModel {

    @SerializedName("stories")
    private List<StoriesModel> stories;

    public List<StoriesModel> getStories() {
        return stories;
    }
}
