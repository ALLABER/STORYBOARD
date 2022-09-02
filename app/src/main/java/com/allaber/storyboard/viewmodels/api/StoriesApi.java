package com.allaber.storyboard.viewmodels.api;

import static com.allaber.storyboard.utils.Constants.Api.STORIES;

import com.allaber.storyboard.models.RootModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StoriesApi {
    @GET(STORIES)
    Call<RootModel> getStories();
}
