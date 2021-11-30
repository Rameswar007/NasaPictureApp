package com.rameswar.nasapictureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class FullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        int position = getIntent().getIntExtra("position",0);

        ViewPager pager = findViewById(R.id.pager);
        ArrayList<NasaData> list = NasaDataRepository.getNasaDataList(this);
        ImagePagerAdapter adapter= new ImagePagerAdapter(list,this);
        pager.setAdapter(adapter);
        pager.setCurrentItem(position);

    }
}