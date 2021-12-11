package com.example.voting_pro.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.voting_pro.Activitys.Registration.Login_Activity;
import com.example.voting_pro.Adapters.MyCategoryRVAdapter;
import com.example.voting_pro.Custom_Classes.Categories.Main_Category;
import com.example.voting_pro.Custom_Classes.MyApp;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.R;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements RecyclerViewsEvent
{

    private RecyclerView rvList;
    private ArrayList<Main_Category> categoriesList;
    private RecyclerView.LayoutManager layoutManager;
    private MyCategoryRVAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        rvList = findViewById(R.id.rvList_Home);

        categoriesList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        myAdapter = new MyCategoryRVAdapter(this, categoriesList);

        rvList.setLayoutManager(layoutManager);

        rvList.setAdapter(myAdapter);


        categoriesList.add(new Main_Category(0, "local", "Local"));

        categoriesList.add(new Main_Category(1, "entertainment", "Entertainment"));

        categoriesList.add(new Main_Category(2, "political", "Political"));

        categoriesList.add(new Main_Category(3, "social", "Social"));



    }

    // this function is taking user category list activity
    @Override
    public void onRecyclerViewsCliked(int index) {


        TastyToast.makeText(getApplicationContext(),"Category for choose to voting "+categoriesList.get(index).getTitle(), TastyToast.LENGTH_LONG, TastyToast.INFO).show();

        Intent intent = new Intent(getApplicationContext(), CategoryList_Activity.class);

        intent.putExtra("index", categoriesList.get(index).getId());

        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        rvList = null;
        categoriesList = null;
        myAdapter = null;
        layoutManager = null;
    }
}