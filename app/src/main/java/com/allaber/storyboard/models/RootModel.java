package com.allaber.storyboard.models;

import com.google.gson.annotations.SerializedName;

public class RootModel {

    @SerializedName("detail")
    private DetailModel detailModel;

    public DetailModel getDetail() {
        return detailModel;
    }
}
