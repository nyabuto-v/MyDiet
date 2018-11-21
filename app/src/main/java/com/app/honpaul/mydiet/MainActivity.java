package com.app.honpaul.mydiet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import AppService.DietApiService;
import Models.Diet;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.app.honpaul.mydiet.R.id.findDietButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Diet diet;
    @BindView(findDietButton) Button mFindDietButton;
    @BindView(R.id.diseaseEditText) EditText mDiseaseEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindDietButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                if (v == mFindDietButton) {
                    String disease = mDiseaseEditText.getText().toString();
                  Intent intent = new Intent(MainActivity.this, DietActivity.class);
                  if(!disease.equals("") && disease.matches("-?\\d+(\\.\\d+)?")){
                      intent.putExtra("Data",disease);
                      startActivity(intent);
                  }
                  else{
                      Toast.makeText(this,"Input Calories",Toast.LENGTH_LONG).show();
                  }
                }
            }
}
