package com.example.navigation_ngang_lan3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation_ngang_lan3.dao.UserDAO;
import com.example.navigation_ngang_lan3.model.User;

public class AddUserActivity extends AppCompatActivity {

    EditText edtName, edtUsername, edtPass, edtAddress, edtPhone;
    Button btnEmpty, btnAddUser;
    UserDAO userDAO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Ánh xạ
        edtName = findViewById(R.id.edt_name_class);
        edtUsername = findViewById(R.id.edt_username_class);
        edtPass = findViewById(R.id.edt_pass_class);
        edtAddress = findViewById(R.id.edt_address_class);
        edtPhone = findViewById(R.id.edt_phone_class);

        btnAddUser = findViewById(R.id.btn_add_user);
        btnEmpty = findViewById(R.id.btn_empty);
        userDAO = new UserDAO(this); // Tạo đối tượng DAO để thao tác với cơ sở dữ liệu

        btnEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                edtUsername.setText("");
                edtPass.setText("");
                edtAddress.setText("");
                edtPhone.setText("");
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo đối tượng User
                User user = new User();
                user.setName(edtName.getText().toString()); // Thay vì setIdClass, bạn nên sử dụng setName
                user.setUsername(edtUsername.getText().toString());
                user.setPassword(edtPass.getText().toString());
                user.setAddress(edtAddress.getText().toString());
                user.setPhone(edtPhone.getText().toString());

                long result = userDAO.insertUser(user); // Thêm đối tượng vào cơ sở dữ liệu

                if (result == -1) {
                    Toast.makeText(AddUserActivity.this, "Thêm người dùng thất bại", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddUserActivity.this, "Thêm người dùng thành công: " + user.getName(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
