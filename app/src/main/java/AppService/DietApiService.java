package AppService;

import android.util.Log;

import com.app.honpaul.mydiet.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Models.Diet;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DietApiService {
      public  static  void  fetchDiets(String search,Callback callback){
          OkHttpClient client=new OkHttpClient();
         HttpUrl.Builder builder=HttpUrl.parse(Constants.DIETS_URL).newBuilder();
         builder.addQueryParameter("q", search);
         builder.addQueryParameter("app_id",Constants.APP_ID);
           builder.addQueryParameter("api_key",Constants.API_KEY);
          builder.addQueryParameter("from", "0");
          builder.addQueryParameter("to", "3");
          builder.addQueryParameter("calories", "519-722");
          builder.addQueryParameter("health", "alcohol-free");
           String url= builder.build().toString();
          Log.d("URL",url);
            Request request=new Request.Builder().url(url).build();
            Call call=client.newCall(request);
            call.enqueue(callback);
      }
public static ArrayList<Diet.Recipe> findDiet(Response response){
          ArrayList<Diet.Recipe> diets= new ArrayList<>();
          try {
              String json = response.body().string();
              if (response.isSuccessful()){
                  JSONObject jsonObject = new JSONObject(json);
                  JSONArray newJson= jsonObject.getJSONArray("recipe");
                  Type type = new TypeToken<List<Diet.Recipe>>() {}.getType();
                  Gson gson = new GsonBuilder().create();
                  diets = gson.fromJson(newJson.toString(), type);
              }
          }catch (IOException e){
              e.printStackTrace();
          }catch (JSONException e){
              e.printStackTrace();
          }
          return diets;
}
}
