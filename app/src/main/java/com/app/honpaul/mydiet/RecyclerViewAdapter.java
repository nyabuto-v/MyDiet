package com.app.honpaul.mydiet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import Models.Diet;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Diet> mDiets = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Diet> diets) {
        mContext = context;
        mDiets = diets;
}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }
}

class ViewHolder extends  RecyclerView.ViewHolder{
    public ViewHolder(View itemView) {
        super(itemView);
    }
}