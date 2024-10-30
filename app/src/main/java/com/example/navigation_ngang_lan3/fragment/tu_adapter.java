package com.example.navigation_ngang_lan3.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigation_ngang_lan3.R;

import java.util.List;

public class tu_adapter extends BaseAdapter {

    Context context;
    List<Class_tu_dien> list;
    int layout;

    public tu_adapter(Context context,int layout, List<Class_tu_dien> list) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        // ánh xạ
        TextView txtTiengviet1 = (TextView) view.findViewById(R.id.txtTiengviet1);
        TextView txtTienganh1 = (TextView) view.findViewById(R.id.txtTienganh1);

        // gán giá trị
        Class_tu_dien classTuDien = list.get(i);
        txtTiengviet1.setText(classTuDien.getTiengviet2());
        txtTienganh1.setText(classTuDien.getTienganh2());
        return view;
    }
}
