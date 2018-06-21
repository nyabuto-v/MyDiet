package com.app.honpaul.mydiet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindDietButton;
    private EditText mDiseaseEditText;
    private TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiseaseEditText = (EditText) findViewById(R.id.diseaseEditText);
        mFindDietButton = (Button) findViewById(R.id.findDietButton);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);
        mFindDietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String disease = mDiseaseEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, DietActivity.class);
                intent.putExtra("disease", disease);
                startActivity(intent);
            }
        });
    }
}
