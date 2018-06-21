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
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.app.honpaul.mydiet.R.id.findDietButton;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(findDietButton) Button mFindDietButton;
    @BindView(R.id.diseaseEditText) EditText mDiseaseEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
