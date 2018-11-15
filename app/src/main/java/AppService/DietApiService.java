package AppService;

import com.app.honpaul.mydiet.Constants;

import java.util.ArrayList;

import Models.Diet;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class DietApiService {
      private  static ArrayList<Diet> diets=new ArrayList<>();

      public static ArrayList<Diet> getDiets() {
            return diets;
      }

      public  static void  addToArrayList(Diet diet){
            diets.add(diet);
      }

      public  static  void  fetchDiets(Callback callback){
            OkHttpClient client=new OkHttpClient();
         HttpUrl.Builder builder=HttpUrl.parse(Constants.DIETS_URL).newBuilder();
            builder.addQueryParameter("q","vegan");
            builder.addQueryParameter("app_id",Constants.APP_ID);
            builder.addQueryParameter("app_key",Constants.API_KEY);
            builder.addQueryParameter("from","0");
            builder.addQueryParameter("to","3");
            builder.addQueryParameter("calories","591-722");
            builder.addQueryParameter("health","alcohol-free");
            String url=builder.build().toString();
            Request request=new Request.Builder()
                    .url(url)
                    .build();
            Call call=client.newCall(request);
            call.enqueue(callback);
      }

}
