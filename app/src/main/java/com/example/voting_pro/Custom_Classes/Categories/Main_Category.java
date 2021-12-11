package com.example.voting_pro.Custom_Classes.Categories;

import java.io.Serializable;

public class Main_Category implements Serializable {

    private int Id;
    private String Image;
    private String Title;

    public Main_Category() {
    }

    public Main_Category(int id, String image, String title) {
        Id = id;
        Image = image;
        Title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return Title;
    }
}
