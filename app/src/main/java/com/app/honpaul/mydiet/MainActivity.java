package com.app.honpaul.mydiet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import AppService.DietApiService;
import Models.Diet;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;
    @BindView(R.id.imageButton) ImageButton mImageButton;
    @BindView(R.id.editText) EditText mEditText;
    @BindView(R.id.recView) RecyclerView recyclerView;
    private ArrayList<Diet.Recipe> diets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Search = mEditText.getText().toString();
               if (!Search.isEmpty()){
                   Intent intent = new Intent(MainActivity.this, MainActivity.class);
                   intent.putExtra("Search", Search);
                   startActivity(intent);
               }
            }
        });
        Intent intent = getIntent();
        String search = intent.getStringExtra("Search");
        findRecipes(search);
    }
    private void findRecipes(String search){
        final DietApiService dietApiService = new DietApiService();
        DietApiService.fetchDiets(search,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            diets = dietApiService.findDiet(response);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, diets);
                    recyclerView.setAdapter(recyclerViewAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                }
            });
            }
        });
    }
}
