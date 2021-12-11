package com.example.voting_pro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voting_pro.Custom_Classes.Categories.Entertainment_Category;
import com.example.voting_pro.Custom_Classes.Categories.Main_Category;
import com.example.voting_pro.Custom_Classes.Categories.Social_Category;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent_CategoryList;
import com.example.voting_pro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MySocialRVAdapter extends RecyclerView.Adapter<MySocialRVAdapter.MyViewHolder> {

    private ArrayList<Social_Category> socialList;
    private RecyclerViewsEvent_CategoryList activity;

    public MySocialRVAdapter(Context context, ArrayList<Social_Category> socialList) {

        this.activity = (RecyclerViewsEvent_CategoryList) context;
        this.socialList = socialList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_layout_ra, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {





        holder.itemView.setTag(socialList.get(position));

        Social_Category social = socialList.get(position);

        holder.tvName.setText(social.getName());

        holder.tvStatus.setText(social.getStatus());

        holder.tvSubject.setText(social.getSubject());

        holder.tvLike.setText(social.getLike_Voting());

        holder.tvNeutral.setText(social.getNeutral_Voting());

        holder.tvDislike.setText(social.getDislike_Voting());

//        holder.socialImage.setImageResource();


    }

    @Override
    public int getItemCount() {
        return socialList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {


        private CircleImageView socialImage;
        private TextView tvName, tvStatus, tvSubject, tvLike, tvNeutral, tvDislike;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);


            tvName = itemView.findViewById(R.id.tvName_CAL);
            tvStatus = itemView.findViewById(R.id.tvStatus_CAL);
            tvSubject = itemView.findViewById(R.id.tvSubject_CAL);
            tvLike = itemView.findViewById(R.id.tvLike_CAL);
            tvNeutral = itemView.findViewById(R.id.tvNeutral_CAL);
            tvDislike = itemView.findViewById(R.id.tvDislike_CAL);
            socialImage = itemView.findViewById(R.id.profileImage_CAL);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onSocialClick( socialList.indexOf( (Social_Category) itemView.getTag() ) );

                }
            });




        }

    }

}
