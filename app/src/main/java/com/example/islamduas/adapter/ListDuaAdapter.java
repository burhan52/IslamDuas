package com.example.islamduas.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.islamduas.R;
import com.example.islamduas.model.Dua;

import java.util.List;

public class ListDuaAdapter extends BaseAdapter {
    private Context mContext;
    private List<Dua> mDuaList;

    public ListDuaAdapter(Context mContext, List<Dua> mDuaList) {
        this.mContext = mContext;
        this.mDuaList = mDuaList;
    }

    @Override
    public int getCount() {
        return mDuaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDuaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDuaList.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v =View.inflate(mContext, R.layout.item_listview, null);
        TextView duaTitle = (TextView)v.findViewById(R.id.duas_title);
        TextView duaDua =(TextView)v.findViewById(R.id.dua);
        TextView duaTransliteration = (TextView)v.findViewById(R.id.transliteration);
        TextView duaTranslation = (TextView)v.findViewById(R.id.translation);
        TextView duaSource =(TextView)v.findViewById(R.id.source);

        return null;
    }
}
