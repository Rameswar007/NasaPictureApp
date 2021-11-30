package com.rameswar.nasapictureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagePagerAdapter  extends PagerAdapter {
    ArrayList<NasaData> data;
    private Context mContext;
    public ImagePagerAdapter(ArrayList<NasaData> data, Context mContext){
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        NasaData modelObject = data.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.full_image_layout, collection, false);
        ImageView imageView = layout.findViewById(R.id.imageView);
        Picasso.get()
                .load(modelObject.getUrl())
                .into(imageView);

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
