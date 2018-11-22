package com.app.honpaul.mydiet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Models.Diet;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

      private ArrayList<Diet.Recipe> recipes = new ArrayList<>();
      private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Diet.Recipe> recipes) {
        mContext = context;
        this.recipes=recipes;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       holder.bindRecipes(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

  public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image) CircleImageView circleImageView;
        @BindView(R.id.image_label) TextView img_label;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindRecipes(Diet.Recipe recipe) {
            Picasso.get().load(recipe.getImage()).into(circleImageView);
            img_label.setText(recipe.getLabel());
        }
    }
}