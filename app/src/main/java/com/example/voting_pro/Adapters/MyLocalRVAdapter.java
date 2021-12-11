package com.example.voting_pro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voting_pro.Custom_Classes.Categories.Local_Category;
import com.example.voting_pro.Custom_Classes.Categories.Main_Category;
import com.example.voting_pro.Custom_Classes.Categories.Political_Category;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent_CategoryList;
import com.example.voting_pro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyLocalRVAdapter extends RecyclerView.Adapter<MyLocalRVAdapter.MyViewHolder> {

    private ArrayList<Local_Category> localList;
    private RecyclerViewsEvent_CategoryList activity;

    public MyLocalRVAdapter(Context context, ArrayList<Local_Category> localList) {

        this.activity = (RecyclerViewsEvent_CategoryList) context;
        this.localList = localList;

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



        holder.itemView.setTag(localList.get(position));

        Local_Category local = localList.get(position);

        holder.tvName.setText(local.getName());

        holder.tvStatus.setText(local.getStatus());

        holder.tvSubject.setText(local.getSubject());

        holder.tvLike.setText(local.getLike_Voting());

        holder.tvNeutral.setText(local.getNeutral_Voting());

        holder.tvDislike.setText(local.getDislike_Voting());

//        holder.localImage.setImageResource();


    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        private CircleImageView localImage;
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
            localImage = itemView.findViewById(R.id.profileImage_CAL);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onLocalClick( localList.indexOf( (Local_Category) itemView.getTag() ) );

                }
            });




        }

    }

}
