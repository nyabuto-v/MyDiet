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
    public static final String

            TAG = MainActivity.class.getSimpleName();
//    private RecyclerView recyclerView;


    @BindView(findDietButton) Button mFindDietButton;
    @BindView(R.id.diseaseEditText) EditText mDiseaseEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

//    recyclerView = (RecyclerView) findViewById(R.id.recylerView);
//    recyclerView.setHasFixedSize(true);
//    recyclerView.setLayoutManager(new LinearLayoutManager(this));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindDietButton.setOnClickListener(this);
        getDiets();

    }

            @Override
            public void onClick(View v) {
                if (v == mFindDietButton) {
                    String disease = mDiseaseEditText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, DietActivity.class);
                    intent.putExtra("disease", disease);
                    startActivity(intent);
                }
            }
            public  void getDiets(){
                DietApiService.fetchDiets(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
//                        Log.d("RESPONSE",response.body().string());
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    JSONObject jsonObject=new JSONObject(response.body().string());
                                    JSONObject params=jsonObject.getJSONObject("params");

                                    Diet diet=new Diet(params.getJSONArray("q").getString(0),params.getJSONArray("health").getString(0),
                                            params.getJSONArray("calories").getString(0));

                                    JSONArray jsonArray=jsonObject.getJSONArray("hits");
                                    Log.d("LENGTH",Integer.toString(jsonArray.length()));
                                    for (int i=0;i<jsonArray.length();i++){
                                        JSONObject hit=jsonArray.getJSONObject(i);
                                        JSONObject recipe =hit.getJSONObject("recipe");
                                        diet.setRecipe(recipe.getString("uri"),recipe.getString("label"),recipe.getString("image"));
                                        Log.d("DATA_URL",recipe.getString("image"));
                                    }


                                }catch (Exception ex){
                                    ex.printStackTrace();
                                }
                            }
                        });

                    }
                });
            }
}
