package com.example.voting_pro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voting_pro.Custom_Classes.Categories.Main_Category;
import com.example.voting_pro.Custom_Classes.Categories.Political_Category;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent_CategoryList;
import com.example.voting_pro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyPoliticalRVAdapter extends RecyclerView.Adapter<MyPoliticalRVAdapter.MyViewHolder> {

    private ArrayList<Political_Category> political_List;
    private RecyclerViewsEvent_CategoryList activity;

    public MyPoliticalRVAdapter(Context context, ArrayList<Political_Category> political_List) {

        this.activity = (RecyclerViewsEvent_CategoryList) context;
        this.political_List = political_List;

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

        holder.itemView.setTag(political_List.get(position));

        Political_Category politician = political_List.get(position);

        holder.tvName.setText(politician.getName());

        holder.tvStatus.setText(politician.getStatus());

        holder.tvSubject.setText(politician.getSubject());

        holder.tvLike.setText(politician.getLike_Voting());

        holder.tvNeutral.setText(politician.getNeutral_Voting());

        holder.tvDislike.setText(politician.getDislike_Voting());

//        holder.politicianImage.setImageResource();


    }

    @Override
    public int getItemCount() {
        return political_List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        private CircleImageView politicianImage;
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
            politicianImage = itemView.findViewById(R.id.profileImage_CAL);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onPoliticalClick( political_List.indexOf( (Political_Category) itemView.getTag() ) );

                }
            });




        }

    }

}
