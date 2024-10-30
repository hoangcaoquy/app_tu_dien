package com.example.navigation_ngang_lan3;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation_ngang_lan3.dao.UserDAO;
import com.example.navigation_ngang_lan3.model.User;

public class EditUserActivity extends AppCompatActivity {
    private UserDAO userDAO;
    private EditText edtName, edtUserName, edtPass, edtAddress, edtPhone;
    private Button btnSave;
    private User selectedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        userDAO = new UserDAO(this);

        edtName = findViewById(R.id.edt_name_class);
        edtUserName = findViewById(R.id.edt_username_class);
        edtPass = findViewById(R.id.edt_pass_class);
        edtAddress = findViewById(R.id.edt_address_class);
        edtPhone = findViewById(R.id.edt_phone_class);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        selectedUser = (User) intent.getSerializableExtra("selected_user");

        // Hiển thị thông tin người dùng trong các EditText
        edtName.setText(selectedUser.getName());
        edtUserName.setText(selectedUser.getUsername());
        edtPass.setText(selectedUser.getPassword());
        edtAddress.setText(selectedUser.getAddress());
        edtPhone.setText(selectedUser.getPhone());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserInfo();
            }
        });
    }

    private void updateUserInfo() {
        String name = edtName.getText().toString().trim();
        String username = edtUserName.getText().toString().trim();
        String password = edtPass.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Tên", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Tài khoản", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        selectedUser.setName(name);
        selectedUser.setUsername(username);
        selectedUser.setPassword(password);
        selectedUser.setAddress(address);
        selectedUser.setPhone(phone);

        new UpdateUserTask().execute(selectedUser);
    }

    private class UpdateUserTask extends AsyncTask<User, Void, Long> {
        @Override
        protected Long doInBackground(User... users) {
            return userDAO.updateUser(users[0]);
        }

        @Override
        protected void onPostExecute(Long updatedRows) {
            if (updatedRows > 0) {
                Toast.makeText(EditUserActivity.this, "Lưu thông tin thành công", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(EditUserActivity.this, "Không thể lưu thông tin", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
