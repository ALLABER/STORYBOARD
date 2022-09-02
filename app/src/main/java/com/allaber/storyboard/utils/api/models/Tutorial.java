package com.allaber.storyboard.utils.api.models;

import java.util.ArrayList;

public class Tutorial {
    public ArrayList<Page> pages;
    public String text_url;
    public String url;
    public int date;
    public String description;
    public String unique_name;
    public String material_url;
    public String news_name;
    public int exp_date;
    public boolean is_add;

    public Tutorial() {
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public String getText_url() {
        return text_url;
    }

    public void setText_url(String text_url) {
        this.text_url = text_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnique_name() {
        return unique_name;
    }

    public void setUnique_name(String unique_name) {
        this.unique_name = unique_name;
    }

    public String getMaterial_url() {
        return material_url;
    }

    public void setMaterial_url(String material_url) {
        this.material_url = material_url;
    }

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }

    public int getExp_date() {
        return exp_date;
    }

    public void setExp_date(int exp_date) {
        this.exp_date = exp_date;
    }

    public boolean isIs_add() {
        return is_add;
    }

    public void setIs_add(boolean is_add) {
        this.is_add = is_add;
    }
}
