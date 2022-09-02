package com.allaber.storyboard.utils.api.models;

import java.util.List;

public class Detail {
    private Info info;
    private Tutorial tutorial;
    private List<Story> stories;

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

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}
