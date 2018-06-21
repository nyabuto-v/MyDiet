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
import butterknife.BindView;

public class DietActivity extends AppCompatActivity {
    @BindView(R.id.listView) TextView mDiseaseTextView;
    @BindView(R.id.diseaseTextView) ListView mListView;
    private String[] diet = new String[] {"Brown Rice and Mushroom soup", "Ugali and Greens",
            "Fruits", "Chapati and Lentils", "No Junk", "5 glasses of water"};

    private String[] category = new String[] {"Lunch", "Breakfast",
            "Every 2 Hrs Before Meals", "Dinner", "All the Time", "Small sips through the day"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);


        MyDietArrayAdapter adapter = new MyDietArrayAdapter(this, android.R.layout.simple_list_item_1, diet, category);
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
