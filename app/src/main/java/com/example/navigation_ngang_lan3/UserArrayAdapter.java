package com.example.navigation_ngang_lan3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.navigation_ngang_lan3.model.User;

import java.util.List;

public class UserArrayAdapter extends ArrayAdapter<User> {
    private List<User> userList;

    public UserArrayAdapter(Context context, List<User> userList) {
        super(context, 0, userList);
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        if (user != null) {
            textView.setText(user.getName()); // Sử dụng trường tên
        }
        return convertView;
    }
}
