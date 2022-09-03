package com.allaber.storyboard.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.allaber.storyboard.models.RootModel;
import com.allaber.storyboard.repositories.StoriesRepository;

public class StoriesViewModel extends AndroidViewModel {
    private StoriesRepository storiesRepository;
    private LiveData<RootModel> rootModelResponseLiveData;

    public StoriesViewModel(@NonNull Application application) {
        super(application);
    }

    public void initialize() {
        storiesRepository = new StoriesRepository();
        rootModelResponseLiveData = storiesRepository.getRootModelResponseLiveData();
    }

    public LiveData<RootModel> getRootModelResponseLiveData() {
        return rootModelResponseLiveData;
    }
}
