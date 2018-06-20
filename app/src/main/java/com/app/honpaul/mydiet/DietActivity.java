package com.app.honpaul.mydiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {
    private TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Find the Diet for Chronic Diseases: " + location);
    }
}
