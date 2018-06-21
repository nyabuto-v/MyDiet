package com.app.honpaul.mydiet;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyDietArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mDiet;
    private String[] mCategory;

    public MyDietArrayAdapter(Context mContext, int resource, String[] mDiet, String[] mCategory) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mDiet = mDiet;
        this.mCategory = mCategory;
    }

    @Override
    public Object getItem(int position) {
        String diet = mDiet[position];
        String category = mCategory[position];
        return String.format("%s \nBest For: %s", diet,category);
    }

    @Override
    public int getCount() {
        return mDiet.length;
    }

}
