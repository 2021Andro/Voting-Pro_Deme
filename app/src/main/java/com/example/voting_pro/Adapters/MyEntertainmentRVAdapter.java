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
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent_CategoryList;
import com.example.voting_pro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyEntertainmentRVAdapter extends RecyclerView.Adapter<MyEntertainmentRVAdapter.MyViewHolder> {

    private ArrayList<Entertainment_Category> entertainmentList;
    private RecyclerViewsEvent_CategoryList activity;

    public MyEntertainmentRVAdapter(Context context, ArrayList<Entertainment_Category> categoriesList) {

        this.activity = (RecyclerViewsEvent_CategoryList) context;
        this.entertainmentList = categoriesList;

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



        holder.itemView.setTag(entertainmentList.get(position));

        Entertainment_Category ntertainment = entertainmentList.get(position);

        holder.tvName.setText(ntertainment.getName());

        holder.tvStatus.setText(ntertainment.getStatus());

        holder.tvSubject.setText(ntertainment.getSubject());

        holder.tvLike.setText(ntertainment.getLike_Voting());

        holder.tvNeutral.setText(ntertainment.getNeutral_Voting());

        holder.tvDislike.setText(ntertainment.getDislike_Voting());

//        holder.entertainmentImage.setImageResource();


    }

    @Override
    public int getItemCount() {
        return entertainmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        private CircleImageView entertainmentImage;
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
            entertainmentImage = itemView.findViewById(R.id.profileImage_CAL);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onEntertainmentClick( entertainmentList.indexOf( (Entertainment_Category)  itemView.getTag() ) );

                }
            });




        }

    }

}
