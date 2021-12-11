package com.example.voting_pro.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.voting_pro.Adapters.MyEntertainmentRVAdapter;
import com.example.voting_pro.Adapters.MyLocalRVAdapter;
import com.example.voting_pro.Adapters.MyPoliticalRVAdapter;
import com.example.voting_pro.Adapters.MySocialRVAdapter;
import com.example.voting_pro.Custom_Classes.Categories.Entertainment_Category;
import com.example.voting_pro.Custom_Classes.Categories.Local_Category;
import com.example.voting_pro.Custom_Classes.Categories.Political_Category;
import com.example.voting_pro.Custom_Classes.Categories.Social_Category;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent_CategoryList;
import com.example.voting_pro.R;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

public class CategoryList_Activity extends AppCompatActivity implements RecyclerViewsEvent_CategoryList {

    private int index;

    private int ACTIVITY_CODE = 1;

    private RecyclerView rvListCategory;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Local_Category> localList;
    private ArrayList<Political_Category> politicalList;
    private ArrayList<Entertainment_Category> entertainmentList;
    private ArrayList<Social_Category> socialList;

    private MyPoliticalRVAdapter politicalRVAdapter;
    private MyLocalRVAdapter localRVAdapter;
    private MyEntertainmentRVAdapter entertainmentRVAdapter;
    private MySocialRVAdapter sociallRVAdapter;

    private Political_Category politician;
    private Local_Category local;
    private Entertainment_Category entertainment;
    private Social_Category social;
    private String Tag = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        // Getting Index of category 0 --> Local
        // Getting Index of category 1 --> Entertainment
        // Getting Index of category 2 --> Political
        // Getting Index of category 3 --> Social
        index = (int) getIntent().getIntExtra("index", 0);

        rvListCategory = findViewById(R.id.rvCategoryList);

        layoutManager = new LinearLayoutManager(this);

        politicalList = new ArrayList<>();
        localList = new ArrayList<>();
        socialList = new ArrayList<>();
        entertainmentList = new ArrayList<>();

        rvListCategory.setLayoutManager(layoutManager);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_CODE)
        {
            if (resultCode == RESULT_CANCELED)
            {

            }
        }





    }

    @Override
    protected void onStart() {
        super.onStart();

        switch (index) {

            case 0: // Local

                // local object
                local = new Local_Category();

                local.setId("0");
                local.setName("Previn");
                local.setStatus("Loyer");
                local.setSubject("Low");
                local.setLike_Voting("1723");
                local.setNeutral_Voting("460");
                local.setDislike_Voting("566");

                localList.add(local);

                localRVAdapter = new MyLocalRVAdapter(this, localList);

                rvListCategory.setAdapter(localRVAdapter);
                Log.d(Tag, "Local Index of category " + index);


                break;

            case 1: // Entertainment

                // entertainment object
                entertainment = new Entertainment_Category();

                entertainment.setId("1");
                entertainment.setName("Nana pateker");
                entertainment.setStatus("Carekter");
                entertainment.setSubject("Social");
                entertainment.setLike_Voting("3123");
                entertainment.setNeutral_Voting("160");
                entertainment.setDislike_Voting("166");

                entertainmentList.add(entertainment);

                entertainmentRVAdapter = new MyEntertainmentRVAdapter(this, entertainmentList);

                rvListCategory.setAdapter(entertainmentRVAdapter);
                Log.d(Tag, "Entertainment Index of category " + index);


                break;

            case 2: // Political

                // political object
                politician = new Political_Category();

                politician.setId("2");
                politician.setName("Yogesh");
                politician.setStatus("Home Minister");
                politician.setSubject("Handicap");
                politician.setLike_Voting("1123");
                politician.setNeutral_Voting("160");
                politician.setDislike_Voting("166");

                politicalList.add(politician);

                politicalRVAdapter = new MyPoliticalRVAdapter(this, politicalList);

                rvListCategory.setAdapter(politicalRVAdapter);
                Log.d(Tag, "Political Index of category " + index);


                break;

            case 3: // Social

                // social object
                social = new Social_Category();

                social.setId("3");
                social.setName("Rakesh");
                social.setStatus("Minister");
                social.setSubject("Lows and oder");
                social.setLike_Voting("2830");
                social.setNeutral_Voting("60");
                social.setDislike_Voting("366");

                socialList.add(social);

                sociallRVAdapter = new MySocialRVAdapter(this, socialList);

                rvListCategory.setAdapter(sociallRVAdapter);
                Log.d(Tag, "Social Index of category " + index);

                break;


        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        politicalList.clear();
        entertainmentList.clear();
        socialList.clear();
        localList.clear();


    }

    // Index of category 0 --> Local
    @Override
    public void onLocalClick(int position) {

        Intent intent = new Intent(getApplicationContext(), VotingBallot_Activity.class);

        intent.putExtra("Local", localList.get(position));

        intent.putExtra("index",0);

        TastyToast.makeText(getApplicationContext(), "Local " + localList.get(position).getName(), TastyToast.LENGTH_LONG, TastyToast.INFO).show();

        startActivityForResult(intent, ACTIVITY_CODE);

        finish();

    }

    // Index of category 1 --> Entertainment
    @Override
    public void onEntertainmentClick(int position) {

        Intent intent = new Intent(getApplicationContext(), VotingBallot_Activity.class);

        intent.putExtra("Entertainment", entertainmentList.get(position));

        intent.putExtra("index",1);


        TastyToast.makeText(getApplicationContext(), "Entertainment " + entertainmentList.get(position).getName(), TastyToast.LENGTH_LONG, TastyToast.INFO).show();

        startActivityForResult(intent, ACTIVITY_CODE);

        finish();

    }

    // Index of category 2 --> Political
    @Override
    public void onPoliticalClick(int position) {

        Intent intent = new Intent(getApplicationContext(), VotingBallot_Activity.class);

        intent.putExtra("Political", politicalList.get(position));

        intent.putExtra("index",2);

        TastyToast.makeText(getApplicationContext(), "Political " + politicalList.get(position).getName(), TastyToast.LENGTH_LONG, TastyToast.INFO).show();

        startActivityForResult(intent, ACTIVITY_CODE);

        finish();


    }

    // Index of category 3 --> Social
    @Override
    public void onSocialClick(int position) {

        Intent intent = new Intent(getApplicationContext(), VotingBallot_Activity.class);

        intent.putExtra("Social", socialList.get(position));

        intent.putExtra("index",3);

        TastyToast.makeText(getApplicationContext(), "Social " + socialList.get(position).getName(), TastyToast.LENGTH_LONG, TastyToast.INFO).show();

        startActivityForResult(intent, ACTIVITY_CODE);

        finish();

    }

}