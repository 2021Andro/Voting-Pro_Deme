package com.example.voting_pro.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.voting_pro.Adapters.MyEntertainmentRVAdapter;
import com.example.voting_pro.Adapters.MyLocalRVAdapter;
import com.example.voting_pro.Adapters.MyPoliticalRVAdapter;
import com.example.voting_pro.Adapters.MySocialRVAdapter;
import com.example.voting_pro.Custom_Classes.Categories.Entertainment_Category;
import com.example.voting_pro.Custom_Classes.Categories.Local_Category;
import com.example.voting_pro.Custom_Classes.Categories.Political_Category;
import com.example.voting_pro.Custom_Classes.Categories.Social_Category;
import com.example.voting_pro.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VotingBallot_Activity extends AppCompatActivity {

    private int index;

    private LinearLayout vbl;

    // file save name
    private String FILE_NAME = "vote.txt";
    // layout reference
    private CircleImageView profileImage;
    private TextView tvName, tvStatus, tvSubject, tvVotingMassage;
    private EditText etThoughts;
    private String thoughts;
    private ProgressBar progressBar;

    // categorise reference
    private Social_Category social;
    private Entertainment_Category entertainment;
    private Local_Category local;
    private Political_Category politician;
    private String votingSubject;

    // save vote
    private SharedPreferences.Editor submitVote;

    // getting Vote
    private SharedPreferences getPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_ballot);

        etThoughts = findViewById(R.id.etThoughtOfVotes_VB);
        tvName = findViewById(R.id.tvName_VB);
        tvStatus = findViewById(R.id.tvStatus_VB);
        tvSubject = findViewById(R.id.tvSubject_VB);
        tvVotingMassage = findViewById(R.id.tvVotingMas_VB);
        vbl = findViewById(R.id.vbl_VB);
        progressBar = findViewById(R.id.progressBar_VB);

        progressBar.setVisibility(View.GONE);

        // submit vote
        submitVote = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();

        // geting voting result
        getPref = getSharedPreferences(FILE_NAME, MODE_PRIVATE);


    }

    // user choose like
    public void buttonLike(View view) {

        if (isViewEmpty())
        {

            submitVote.putBoolean(votingSubject, true);

            submitVote.commit();

            startActivity(new Intent(getApplicationContext(), CategoryList_Activity.class));
            finish();

        }

    }

    // user choose neutral
    public void buttonNeutral(View view) {


        if (isViewEmpty())
        {

            submitVote.putBoolean(votingSubject, true);
            
            submitVote.commit();

            startActivity(new Intent(getApplicationContext(), CategoryList_Activity.class));
            finish();


        }

    }

    // user choose dislike
    public void buttonDislike(View view) {

        if (isViewEmpty())
        {
            submitVote.putBoolean(votingSubject, true);

            submitVote.commit();

            startActivity(new Intent(getApplicationContext(), CategoryList_Activity.class));
            finish();


        }

    }

    // check view empty or not
    private boolean isViewEmpty() {

        boolean result = true;

        thoughts = etThoughts.getText().toString().trim();

        if (thoughts.isEmpty())
        {

            etThoughts.setError("Enter your thoughts for this vote");
            result = false;

        }else if (thoughts.length() >= 25)
        {

            etThoughts.setError("Enter your thoughts for 25 characters");
            result = false;

        }


        return result;

    }

    @Override
    protected void onStart() {
        super.onStart();


        index = (int) getIntent().getIntExtra("index",0);


        switch (index) {

            case 0: // Local

                // local object
                local = (Local_Category) getIntent().getSerializableExtra("Local");

                votingSubject = local.getSubject();

                tvName.setText(local.getName());
                tvStatus.setText(local.getStatus());
                tvSubject.setText(local.getSubject());

                break;

            case 1: // Entertainment

                // entertainment object
                entertainment = (Entertainment_Category) getIntent().getSerializableExtra("Entertainment");

                votingSubject = entertainment.getSubject();

                tvName.setText(entertainment.getName());
                tvStatus.setText(entertainment.getStatus());
                tvSubject.setText(entertainment.getSubject());

                break;

            case 2: // Political

                // political object
                politician = (Political_Category) getIntent().getSerializableExtra("Political");

                votingSubject = politician.getSubject();

                tvName.setText(politician.getName());
                tvStatus.setText(politician.getStatus());
                tvSubject.setText(politician.getSubject());


                break;

            case 3: // Social

                // social object
                social =  (Social_Category) getIntent().getSerializableExtra("Social");

                votingSubject = social.getSubject();

                tvName.setText(social.getName());
                tvStatus.setText(social.getStatus());
                tvSubject.setText(social.getSubject());

                break;


        }

        boolean result = getPref.getBoolean(votingSubject, false);

        if (result)
        {

            vbl.setVisibility(View.GONE);
            tvVotingMassage.setVisibility(View.VISIBLE);

        }else {

            vbl.setVisibility(View.VISIBLE);
            tvVotingMassage.setVisibility(View.GONE);

        }

    }
}