package com.allaber.storyboard.models;

import static com.allaber.storyboard.utils.Constants.TimeUtils.PATTERN_DDMMYYYY;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.allaber.storyboard.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoriesModel {
    @SerializedName("image_logo")
    private String storiesPreview;

    @SerializedName("news_name")
    private String storiesTitle;

    @SerializedName("date")
    private long storiesDate;

    @SerializedName("url")
    private String storiesLink;

    public String getStoriesDate() {
        Date newsDate = new Date(storiesDate * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DDMMYYYY);
        return simpleDateFormat.format(newsDate);
    }

    @BindingAdapter("android:src")
    public static void imageLoader(ImageView imageView, String url) {
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.news_placeholder)
                .into(imageView);
    }

    public String getStoriesPreview() {
        return storiesPreview;
    }

    public String getStoriesTitle() {
        return storiesTitle;
    }

    public String getStoriesLink() {
        return storiesLink;
    }
}
