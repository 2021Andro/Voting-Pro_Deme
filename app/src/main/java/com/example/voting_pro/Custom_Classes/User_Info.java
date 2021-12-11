package com.example.voting_pro.Custom_Classes;

import java.io.Serializable;

public class User_Info implements Serializable {

    private String Key_Id;
    private String Profile_Image;
    public String Name;
    private String Email_Id;
    private String Phone_Number;

    public User_Info() {
    }

    public User_Info(String key_Id, String profile_Image, String name, String email_Id, String phone_Number) {
        Key_Id = key_Id;
        Profile_Image = profile_Image;
        Name = name;
        Email_Id = email_Id;
        Phone_Number = phone_Number;
    }

    public User_Info(String profile_Image, String name, String email_Id, String phone_Number) {
        Profile_Image = profile_Image;
        Name = name;
        Email_Id = email_Id;
        Phone_Number = phone_Number;
    }

    public User_Info(String name, String email_Id, String phone_Number) {
        Name = name;
        Email_Id = email_Id;
        Phone_Number = phone_Number;
    }

    public String getKey_Id() {
        return Key_Id;
    }

    public void setKey_Id(String key_Id) {
        Key_Id = key_Id;
    }

    public String getProfile_Image() {
        return Profile_Image;
    }

    public void setProfile_Image(String profile_Image) {
        Profile_Image = profile_Image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail_Id() {
        return Email_Id;
    }

    public void setEmail_Id(String email_Id) {
        Email_Id = email_Id;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    @Override
    public String toString() {
        return Name;
    }
}
