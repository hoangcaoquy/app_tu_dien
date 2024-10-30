package com.example.navigation_ngang_lan3.fragment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigation_ngang_lan3.R;

public class Sua_Xoa_quy extends AppCompatActivity {

    Button btnXoa, btnSua;
    EditText edtTienganh, edtTiengviet;
    DataSqlite2 dataSqlite2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_xoa_quy);

        // Ánh xạ các thành phần trong layout
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        edtTienganh = findViewById(R.id.edtTienganh);
        edtTiengviet = findViewById(R.id.edtTiengviet);

        // Khởi tạo đối tượng DataSqlite2
        dataSqlite2 = new DataSqlite2(Sua_Xoa_quy.this, "Tudien2", null, 1);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String tienganh = intent.getStringExtra("tienganh");
            String tiengviet = intent.getStringExtra("tiengviet");

            // Hiển thị dữ liệu nhận được lên EditText
            edtTienganh.setText(tienganh);
            edtTiengviet.setText(tiengviet);
        }

        // nút sủa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String englishValue = edtTienganh.getText().toString();
                String vietnameseValue = edtTiengviet.getText().toString();
                String sql_update = "UPDATE dictionary1 SET vietnamese='" + vietnameseValue + "' WHERE english='" + englishValue + "'";
                dataSqlite2.ExecuteSql(sql_update);
                // Hiển thị Toast thông báo thành công
                Toast.makeText(Sua_Xoa_quy.this, "Sửa dữ liệu thành công", Toast.LENGTH_SHORT).show();

                // Quay lại trang đầu
                finish();
            }
        });

        //nút xoá dữ liệu
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String englishValue = edtTienganh.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(Sua_Xoa_quy.this);
                builder.setTitle("Xác nhận xoá");
                builder.setMessage("Bạn có chắc chắn muốn xoá dữ liệu?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql_delete = "DELETE FROM dictionary1 WHERE english='" + englishValue + "'";
                        dataSqlite2.ExecuteSql(sql_delete);
                        // Hiển thị Toast thông báo thành công
                        Toast.makeText(Sua_Xoa_quy.this, "Xoá dữ liệu thành công", Toast.LENGTH_SHORT).show();

                        // Quay lại trang đầu
                        finish();
                    }
                });
                builder.setNegativeButton("Không", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
    public void onStarIconClicked(View view) {
        //update thooi  dữ liệu vào bảng
        String englishValue1 = edtTienganh.getText().toString();
        String sql_update1 = "UPDATE dictionary1 SET trangthai = 1 WHERE english ='" + englishValue1 + "' ";
        dataSqlite2.ExecuteSql(sql_update1);

        Toast.makeText(Sua_Xoa_quy.this, "Đã thêm vào yêu thích :)", Toast.LENGTH_SHORT).show();
        // Quay lại trang đầu
        finish();

    }
}