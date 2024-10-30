package com.example.navigation_ngang_lan3.minh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigation_ngang_lan3.R;

import java.util.List;

public class verb_adapter extends BaseAdapter {

    Context context;
    List<verb> list;
    int layout;

    public verb_adapter(Context context, int layout, List<verb> list) {
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
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        //ánh xạ
        TextView txtverb = (TextView) view.findViewById(R.id.txtverb);
        TextView txtpast = (TextView) view.findViewById(R.id.txtpast);
        TextView txtpii = (TextView) view.findViewById(R.id.txtpii);

        // gán giá trị
        verb dt = list.get(i);
        txtverb.setText(dt.getVerb());
        txtpast.setText(dt.getPast());
        txtpii.setText(dt.getPii());
        return view;
    }
}
