package com.allaber.storyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.allaber.storyboard.utils.api.Services;
import com.allaber.storyboard.utils.api.StoriesApi;
import com.allaber.storyboard.utils.api.models.Root;
import com.allaber.storyboard.utils.api.models.Story;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Services services = new Services();
        StoriesApi storiesApi = services.getStoriesApi();

        Call<Root> stories = storiesApi.getStories();

        stories.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if(response.isSuccessful()) {
                    ArrayList<Story> stories = response.body().getDetail().getStories();
                } else {
                    Toast.makeText(getApplicationContext(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unknown error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}