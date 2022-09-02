package com.allaber.storyboard.utils.api;

import static com.allaber.storyboard.utils.Constants.Api.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {

    private static Retrofit.Builder retrofitBuilder =
        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static StoriesApi storiesApi = retrofit.create(StoriesApi.class);

    public StoriesApi getStoriesApi() {
        return storiesApi;
    }

}
