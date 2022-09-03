package com.allaber.storyboard.services;

import static com.allaber.storyboard.utils.Constants.Api.BASE_URL;

import com.allaber.storyboard.apis.StoriesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static Retrofit.Builder retrofitBuilder =
        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static StoriesApi storiesApi;

    public StoriesApi getStoriesApi() {
        return storiesApi == null ?
                storiesApi = retrofit.create(StoriesApi.class) :
                storiesApi;
    }

}
