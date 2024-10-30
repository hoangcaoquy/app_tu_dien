package com.example.navigation_ngang_lan3;

import static java.security.AccessController.getContext;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation_ngang_lan3.fragment.DataSqlite2;
import com.example.navigation_ngang_lan3.fragment.Sua_Xoa_quy;

public class login_activity extends AppCompatActivity {
    String tk, mk;
    EditText edtUserName, edtPassword, edttk, edtmk;
    Button btnDangNhap, btnDangKy, btnDangXuat;
    CheckBox chkLuu;
    SharedPreferences sharedPreferences;
    DataUser dataUser = new DataUser(this, "DataUser", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapping();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        edtUserName.setText(sharedPreferences.getString("userName", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        chkLuu.setChecked(sharedPreferences.getBoolean("isCheck", false));
    }
    public void login(View view) {
       /* String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        boolean isCheck = chkLuu.isChecked();
            if (userName.equals("admin") && password.equals("123456") ) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (isCheck) {
                    editor.putString("userName", userName);
                    editor.putString("password", password);
                    editor.putBoolean("isCheck", isCheck);
                    editor.commit();
                } else {
                    editor.remove("userName");
                    editor.remove("password");
                    editor.remove("isCheck");
                    editor.commit();
                }

                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            } */
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUserName.getText().length() != 0 && edtPassword.getText().length() != 0) {
                    if(edtUserName.getText().toString().equals(tk) && edtPassword.getText().toString().equals(mk)){
                        Toast.makeText(login_activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_activity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (edtUserName.getText().toString().equals("admin") && edtPassword.getText().toString().equals("123456")){
                        Toast.makeText(login_activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_activity.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(login_activity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(login_activity.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void signup(View view){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(login_activity.this);
                dialog.setTitle("Xử lý thông tin đăng ký");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_singup);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
                Button btnDongY = (Button) dialog.findViewById(R.id.btnDongY);
                btnDongY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tk = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtUserName.setText(tk);
                        edtPassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();


            }

        });




    }


    private void mapping() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy = findViewById(R.id.btnDangKy);
        //btnDangXuat = findViewById(R.id.btnDangXuat);
        chkLuu = findViewById(R.id.chkLuu);

    }
}
