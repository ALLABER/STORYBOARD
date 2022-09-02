package com.allaber.storyboard.utils.api;

import static com.allaber.storyboard.utils.Constants.Api.STORIES;

import com.allaber.storyboard.utils.api.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StoriesApi {
    @GET(STORIES)
    Call<Root> getStories();
}
