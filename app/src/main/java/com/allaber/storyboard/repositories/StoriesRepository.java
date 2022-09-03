package com.allaber.storyboard.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.allaber.storyboard.models.RootModel;
import com.allaber.storyboard.services.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoriesRepository {
    private MutableLiveData<RootModel> rootModelResponseLiveData;
    private NetworkService networkService;

    public StoriesRepository() {
        rootModelResponseLiveData = new MutableLiveData<>();
        networkService = new NetworkService();
        loadNetworkServiceData();
    }

    private void loadNetworkServiceData() {
        networkService.getStoriesApi().getStories().enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                rootModelResponseLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable t) {
                rootModelResponseLiveData.postValue(null);
            }
        });
    }

    public LiveData<RootModel> getRootModelResponseLiveData() {
        return rootModelResponseLiveData;
    }
}
