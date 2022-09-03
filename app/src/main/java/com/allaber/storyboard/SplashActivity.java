package com.allaber.storyboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.allaber.storyboard.views.StoryboardActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startActivity(getIntentActivity());
        this.finishAffinity();
    }

    private Intent getIntentActivity() {
        return new Intent(this, StoryboardActivity.class);
    }
}