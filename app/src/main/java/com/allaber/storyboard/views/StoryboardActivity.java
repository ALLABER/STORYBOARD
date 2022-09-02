package com.allaber.storyboard.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import com.allaber.storyboard.R;
import com.allaber.storyboard.viewmodels.adapter.StoriesAdapter;
import com.allaber.storyboard.databinding.ActivityStoryboardBinding;
import com.allaber.storyboard.models.StoriesModel;
import com.allaber.storyboard.viewmodels.api.NetworkService;
import com.allaber.storyboard.viewmodels.api.StoriesApi;
import com.allaber.storyboard.models.RootModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryboardActivity extends AppCompatActivity {

    private ActivityStoryboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_storyboard);
        populateData();
    }

    private void populateData(){
        if(hasInternetConnection()) {
            showToastMessage(getString(R.string.string_no_internet_connection));
        } else {
            loadNetworkServiceData();
        }
    }

    protected boolean hasInternetConnection() {
        String connectivityService = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager systemService = (ConnectivityManager) getSystemService(connectivityService);
        return systemService.getActiveNetworkInfo() == null;
    }

    private void loadNetworkServiceData() {
        NetworkService networkService = new NetworkService();
        StoriesApi storiesApi = networkService.getStoriesApi();
        Call<RootModel> stories = storiesApi.getStories();
        enqueueStories(stories);
    }

    private void enqueueStories(Call<RootModel> stories) {
        stories.enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                responseResultProcessing(response);
            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable throwable) {
                showToastMessage(throwable.getMessage());
            }
        });
    }

    private void responseResultProcessing(Response<RootModel> response) {
        if(response.isSuccessful()) {
            List<StoriesModel> stories = response.body().getDetail().getStories();
            StoriesAdapter adapter = new StoriesAdapter(stories, getApplicationContext());
            binding.setStoriesAdapter(adapter);
        } else {
            showToastMessage(response.message());
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), getString(R.string.string_error) + message, Toast.LENGTH_SHORT).show();
    }
}