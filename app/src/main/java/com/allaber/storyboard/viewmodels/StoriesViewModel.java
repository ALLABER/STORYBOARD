package com.allaber.storyboard.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.allaber.storyboard.models.RootModel;
import com.allaber.storyboard.repositories.StoriesRepository;

public class StoriesViewModel extends ViewModel {
    private StoriesRepository storiesRepository;
    private LiveData<RootModel> rootModelResponseLiveData;

    public StoriesViewModel() {
        initialize();
    }

    private void initialize() {
        storiesRepository = new StoriesRepository();
        rootModelResponseLiveData = storiesRepository.getRootModelResponseLiveData();
    }

    public LiveData<RootModel> getRootModelResponseLiveData() {
        return rootModelResponseLiveData;
    }
}
