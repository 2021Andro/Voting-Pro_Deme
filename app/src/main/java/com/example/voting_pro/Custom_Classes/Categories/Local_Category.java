package com.example.voting_pro.Custom_Classes.Categories;

import java.io.Serializable;

public class Local_Category implements Serializable {

    private String Id;
    private String ProfileImage;
    private String Name;
    private String Status;
    private String Subject;
    private String Like_Voting;
    private String Neutral_Voting;
    private String Dislike_Voting;
    private String All_Voting;

    public Local_Category() {
    }

    public Local_Category(String id, String profileImage, String name, String status, String subject, String like_Voting, String neutral_Voting, String dislike_Voting, String all_Voting) {
        Id = id;
        ProfileImage = profileImage;
        Name = name;
        Status = status;
        Subject = subject;
        Like_Voting = like_Voting;
        Neutral_Voting = neutral_Voting;
        Dislike_Voting = dislike_Voting;
        All_Voting = all_Voting;
    }

    public Local_Category(String profileImage, String name, String status, String subject, String like_Voting, String neutral_Voting, String dislike_Voting, String all_Voting) {
        ProfileImage = profileImage;
        Name = name;
        Status = status;
        Subject = subject;
        Like_Voting = like_Voting;
        Neutral_Voting = neutral_Voting;
        Dislike_Voting = dislike_Voting;
        All_Voting = all_Voting;
    }

    public Local_Category(String name, String status, String subject, String like_Voting, String neutral_Voting, String dislike_Voting, String all_Voting) {
        Name = name;
        Status = status;
        Subject = subject;
        Like_Voting = like_Voting;
        Neutral_Voting = neutral_Voting;
        Dislike_Voting = dislike_Voting;
        All_Voting = all_Voting;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getLike_Voting() {
        return Like_Voting;
    }

    public void setLike_Voting(String like_Voting) {
        Like_Voting = like_Voting;
    }

    public String getNeutral_Voting() {
        return Neutral_Voting;
    }

    public void setNeutral_Voting(String neutral_Voting) {
        Neutral_Voting = neutral_Voting;
    }

    public String getDislike_Voting() {
        return Dislike_Voting;
    }

    public void setDislike_Voting(String dislike_Voting) {
        Dislike_Voting = dislike_Voting;
    }

    public String getAll_Voting() {
        return All_Voting;
    }

    public void setAll_Voting(String all_Voting) {
        All_Voting = all_Voting;
    }

    @Override
    public String toString() {
        return Name;
    }
}
