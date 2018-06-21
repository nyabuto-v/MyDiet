package com.app.honpaul.mydiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {
    private TextView mDiseaseTextView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        mDiseaseTextView = (TextView) findViewById(R.id.diseaseTextView);
        Intent intent = getIntent();
        String disease = intent.getStringExtra("disease");
        mDiseaseTextView.setText("Find the Diet for Chronic Disease: " + disease);
//        mListView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, diet);
//        mListView.setAdapter(adapter);
    }
}
