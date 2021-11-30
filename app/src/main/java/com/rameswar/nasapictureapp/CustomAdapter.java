package com.rameswar.nasapictureapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<NasaData> list;
        Context context;
        public CustomAdapter(Context context, ArrayList<NasaData> list) {
            this.context = context;
            this.list = list;
        }
        @Override
        public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // infalte the item Layout
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_layout, parent, false);
            // set the view's size, margins, paddings and layout parameters
            CustomAdapter.MyViewHolder vh = new CustomAdapter.MyViewHolder(v); // pass the view to View Holder
            return vh;
        }

        @Override
        public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, final int position) {
            final NasaData data = list.get(position);
            Picasso.get()
                    .load(data.getUrl())
                    .resize(90, 90)
                    .centerCrop()
                    .into(holder.image);;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });
        }
        @Override
        public int getItemCount() {
            return this.list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            // init the item view's
            ImageView image;
            public MyViewHolder(final View itemView) {
                super(itemView);
                // get the reference of item view's
                image = itemView.findViewById(R.id.image);
            }
        }
    }
    