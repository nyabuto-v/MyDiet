package com.app.honpaul.mydiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
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

public class DietActivity extends AppCompatActivity {
    Diet diet;
    @BindView(R.id.recView) RecyclerView recyclerView;
    private ArrayList<Diet> diets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        getDiets(intent.getStringExtra("Data"));
    }
    public void getDiets(String calories){
        DietApiService.fetchDiets(calories,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d("RESPONSE",response.body().string());
                DietActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            JSONObject jsonObject=new JSONObject(response.body().string());
                            JSONObject params=jsonObject.getJSONObject("params");
                            diet=new Diet(params.getJSONArray("q").getString(0),params.getJSONArray("health").getString(0),
                                    params.getJSONArray("calories").getString(0));
                            JSONArray jsonArray=jsonObject.getJSONArray("hits");
                            Log.d("LENGTH",Integer.toString(jsonArray.length()));
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                JSONObject recipe =hit.getJSONObject("recipe");
                                diet.setRecipe(recipe.getString("uri"),recipe.getString("label"),recipe.getString("image"));
                                Log.d("DATA_URL",recipe.getString("image"));
                            }
                            Diet.diet=diet;
//                            recyclerView.setLayoutManager(new LinearLayoutManager(this));
//                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, );
//                            recyclerView.setAdapter(adapter);
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
