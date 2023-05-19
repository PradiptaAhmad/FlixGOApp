package com.example.flixgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    Button btnNext;
    LinearLayout dotLayout;
    ViewPagerAdapter viewPagerAdapter;
    TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        btnNext = findViewById(R.id.btnnext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        dotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

    }

    public void SetUpIndicator (int position) {

        dots = new TextView[4];
        dotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            dotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.white, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            SetUpIndicator(position);

            if (position > 0)

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}