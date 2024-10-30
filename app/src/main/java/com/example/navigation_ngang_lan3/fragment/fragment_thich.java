package com.example.navigation_ngang_lan3.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigation_ngang_lan3.R;

import java.util.ArrayList;

public class fragment_thich extends Fragment {

    ListView lvthich;
    DataSqlite2 dataSqlite2 = null;
    ArrayList<Class_tu_dien> arrayData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_thich_quy1, container, false);

        // anh xa o day
        ListView lvthich = view.findViewById(R.id.lvthich);
        dataSqlite2 = new DataSqlite2(getContext(),"Tudien2",null,1);

        String sql_select = "SELECT * FROM dictionary1 WHERE trangthai LIKE '1'";
        Cursor cursor = dataSqlite2.SelectData(sql_select);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String english = cursor.getString(1);
            String vietnamese = cursor.getString(2);

            arrayData.add(new Class_tu_dien(english,vietnamese));
        }

        tu_adapter adapter = new tu_adapter(getContext(), R.layout.item_listview, arrayData);
        lvthich.setAdapter(adapter);

        return view;
    }
}
