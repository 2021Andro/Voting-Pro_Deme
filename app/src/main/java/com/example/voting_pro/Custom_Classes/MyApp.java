package com.example.voting_pro.Custom_Classes;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MyApp extends Application
{
    public static String PASSING_USER_INFO_OBJECT_KEY = "User_Info";
    public static String USER_INFO_COLLECTION_NAME = "User_Information";
    public static String TAG = "MyTag";
    public static FirebaseAuth myAuth;
    public static FirebaseUser myUser;

    public static FirebaseFirestore myFirestore;

    @Override
    public void onCreate() {
        super.onCreate();

        // this app database is Voting (newclass5a@gmail.com) project

        myAuth = FirebaseAuth.getInstance();

        myFirestore = FirebaseFirestore.getInstance();


    }
}
