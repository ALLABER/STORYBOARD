package com.allaber.storyboard.utils.api.models;

import java.util.ArrayList;

public class Detail {
    public Info info;
    public Tutorial tutorial;
    public ArrayList<Story> stories;

    public Detail() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }
}
