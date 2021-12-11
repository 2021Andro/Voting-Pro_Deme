package com.example.voting_pro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voting_pro.Custom_Classes.Categories.Main_Category;
import com.example.voting_pro.Interfaces.RecyclerViewsEvent;
import com.example.voting_pro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCategoryRVAdapter extends RecyclerView.Adapter<MyCategoryRVAdapter.MyViewHolder> {

    private ArrayList<Main_Category> categoriesList;
    private RecyclerViewsEvent activity;

    public MyCategoryRVAdapter(Context context, ArrayList<Main_Category> categoriesList) {

        this.activity = (RecyclerViewsEvent) context;
        this.categoriesList = categoriesList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_mc_a_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        Main_Category category = categoriesList.get(position);

        holder.itemView.setTag(categoriesList.get(position));

        String categoryImage = category.getImage();


        if (categoryImage.equals("local"))
        {
            // 0
            holder.categoryImage.setImageResource(R.drawable.local);
            holder.tvTitle.setText(category.getTitle());

        }
        else if (categoryImage.equals("entertainment"))
        {

            // 1
            holder.categoryImage.setImageResource(R.drawable.entertainment);
            holder.tvTitle.setText(category.getTitle());
        }
        else if (categoryImage.equals("political"))
        {

            // 2
            holder.categoryImage.setImageResource(R.drawable.political);
            holder.tvTitle.setText(category.getTitle());
        }
        else if (categoryImage.equals("social"))
        {

            // 3
            holder.categoryImage.setImageResource(R.drawable.social);
            holder.tvTitle.setText(category.getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        private CircleImageView categoryImage;
        private TextView tvTitle;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle_Category);
            categoryImage = itemView.findViewById(R.id.profileImage_Category);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onRecyclerViewsCliked( categoriesList.indexOf( (Main_Category) itemView.getTag() ) );

                }
            });




        }

    }

}
