package com.app.honpaul.mydiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DietActivity extends AppCompatActivity {
    private TextView mDiseaseTextView;
    private ListView mListView;
    private String[] diet = new String[] {"Brown Rice and Mushroom soup", "Ugali and Greens",
            "Fruits", "Chapati and Lentils", "No Junk", "5 glasses of water"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        mListView = (ListView) findViewById(R.id.listView);
        mDiseaseTextView = (TextView) findViewById(R.id.diseaseTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, diet);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String diet = ((TextView)view).getText().toString();
                Toast.makeText(DietActivity.this, diet, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String disease = intent.getStringExtra("disease");
        mDiseaseTextView.setText("Find the Diet for Chronic Disease: " + disease);

    }
}
