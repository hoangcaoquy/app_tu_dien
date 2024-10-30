package com.example.navigation_ngang_lan3.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigation_ngang_lan3.R;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Class_them_lan2 extends AppCompatActivity {

    EditText edtTienganh3,edtTiengviet3;
    Button btnThem;
    DataSqlite2 dataSqlite2 = new DataSqlite2(Class_them_lan2.this,"Tudien2",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_du_lieu);

        //ánh xạ ở đây
        btnThem = findViewById(R.id.btnThem);
        edtTienganh3 = findViewById(R.id.edtTienganh3);
        edtTiengviet3 = findViewById(R.id.edtTiengviet3);

        // bắt sự kiện click vào button
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Tienganh3 = edtTienganh3.getText().toString();
                String Tiengviet3 = edtTiengviet3.getText().toString();

                //thêm dữ liệu vào bảng
                String sql1 = "INSERT INTO dictionary1 VALUES (null,'" + Tienganh3 + "', '" + Tiengviet3 + "','0')";
                dataSqlite2.ExecuteSql(sql1);
                // Hiển thị Toast thông báo thành công
                Toast.makeText(Class_them_lan2.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();

                // từ đây là post dữ liệu api
                // Tạo đối tượng từ điển
//                tudien_api dictionary = new tudien_api(Tienganh3, Tiengviet3);
//
//                // Chuyển đổi đối tượng từ điển thành chuỗi JSON
//                Gson gson = new Gson();
//                String jsonDictionary = gson.toJson(dictionary);
//
//                // Gửi yêu cầu POST và truyền dữ liệu từ điển JSON
//                api_service.api_service.postDich(jsonDictionary).enqueue(new Callback<List<tudien_api>>() {
//                    @Override
//                    public void onResponse(Call<List<tudien_api>> call, Response<List<tudien_api>> response) {
//                        if (response.isSuccessful()) {
//                            Toast.makeText(Class_them_lan2.this   , "Đã lưu thành công", Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<tudien_api>> call, Throwable t) {
//                        Log.e("EEEE", t.getMessage(), t);
//                        Toast.makeText(Class_them_lan2.this, "Lỗi rồi", Toast.LENGTH_LONG).show();
//                    }
//                }) ;

                // Quay lại trang đầu
                finish();

            }
        });
    }
}