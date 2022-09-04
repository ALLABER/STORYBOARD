package com.allaber.storyboard.services;

import static com.allaber.storyboard.utils.Constants.Api.BASE_URL;

import com.allaber.storyboard.apis.StoriesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();

    private static StoriesApi storiesApi;

    public StoriesApi getStoriesApi() {
        return storiesApi == null ?
                storiesApi = retrofit.create(StoriesApi.class) :
                storiesApi;
    }

}
