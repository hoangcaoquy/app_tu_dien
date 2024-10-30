package com.example.navigation_ngang_lan3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
    Button btnAddUser, btnViewUserList, btnStudentManage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnAddUser = findViewById(R.id.btn_add_user);
        btnViewUserList = findViewById(R.id.btn_view_user_list);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, AddUserActivity.class);
                startActivity(intent);
            }
        });

        btnViewUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, ViewUserListActivity.class);
                startActivity(intent);
            }
        });
}
}
