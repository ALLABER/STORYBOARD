package com.allaber.storyboard.views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.allaber.storyboard.R;
import com.allaber.storyboard.databinding.ActivityStoryboardBinding;
import com.allaber.storyboard.viewmodels.StoriesViewModel;
import com.allaber.storyboard.adapters.StoriesAdapter;

public class StoryboardActivity extends AppCompatActivity {

    private StoriesViewModel storiesViewModel;
    private ActivityStoryboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_storyboard);
        storiesViewModel = ViewModelProviders.of(this).get(StoriesViewModel.class);
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
        storiesViewModel.getRootModelResponseLiveData().observe(this, rootModel -> {
            if (rootModel != null) {
                StoriesAdapter adapter = new StoriesAdapter(rootModel.getDetail().getStories(), this);
                binding.setStoriesAdapter(adapter);
            } else {
                showToastMessage(getString(R.string.string_try_get_data));
            }
        });
    }

    private void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), getString(R.string.string_error) + message, Toast.LENGTH_SHORT).show();
    }
}