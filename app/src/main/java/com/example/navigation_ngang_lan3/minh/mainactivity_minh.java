package com.example.navigation_ngang_lan3.minh;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.navigation_ngang_lan3.R;

import java.util.ArrayList;

public class mainactivity_minh extends Fragment {
    EditText et1,et2,et3;
    Button btnthem, btnxoa, btnsua;
    ListView lv;
    Cuoikihelper cuoikihelper = new Cuoikihelper(getContext(),"dt.sql",null,1);
    ArrayList<verb> arrayData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_minh, container, false);

        cuoikihelper = new Cuoikihelper(requireContext(),"dt.sql",null,1);

        btnxoa = view.findViewById(R.id.btnxoa);
        btnsua = view.findViewById(R.id.btnsua);
        btnthem = view.findViewById(R.id.btnthem);
        et1 = view.findViewById(R.id.et1);
        et2 = view.findViewById(R.id.et2);
        et3 = view.findViewById(R.id.et3);
        lv = view.findViewById(R.id.lv);


        //đây là chỗ tạo bảng
//        cuoikihelper = new Cuoikihelper(requireContext(),"dt.sql",null,1);
        String sql_create_table = "CREATE TABLE IF NOT EXISTS bqt(id INTEGER PRIMARY KEY AUTOINCREMENT, verb VARCHAR(50), past VARCHAR(50),pii VARCHAR(50))";
        cuoikihelper.ExecuteSql(sql_create_table);


        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verb = et1.getText().toString();
                String past = et2.getText().toString();
                String Pii = et3.getText().toString();


                //thêm dữ liệu vào bảng
                String sql1 = "INSERT INTO bqt VALUES (null,'" + verb + "', '" + past + "', '"+ Pii +"')";
                cuoikihelper.ExecuteSql(sql1);
                // Hiển thị Toast thông báo thành công
                Toast.makeText(requireContext(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();

            }
        });
        loadlistview();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verb item = (verb) lv.getItemAtPosition(position);

                String verb = item.getVerb();


                String past = item.getPast();

                String pii = item.getPii();
                et1.setText(verb);
                et2.setText(past);
                et3.setText(pii);


            }
        });

        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verbValue = et1.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Xác nhận xoá");
                builder.setMessage("Bạn có chắc chắn muốn xoá dữ liệu?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql_delete = "DELETE FROM bqt WHERE verb='" + verbValue + "'";
                        cuoikihelper.ExecuteSql(sql_delete);
                        // Hiển thị Toast thông báo thành công
                        Toast.makeText(requireContext(), "Xoá dữ liệu thành công", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("Không", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }

        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verbValue = et1.getText().toString();
                String pastValue = et2.getText().toString();
                String piiValue = et3.getText().toString();
                String sql_update = "UPDATE bqt SET past='" + pastValue + "', pii='"+ piiValue +"' WHERE verb='" + verbValue + "'";
                cuoikihelper.ExecuteSql(sql_update);
                // Hiển thị Toast thông báo thành công
                Toast.makeText(requireContext(), "Sửa dữ liệu thành công", Toast.LENGTH_SHORT).show();

                // Quay lại trang đầu

            }
        });

        return view;
    }
    private void loadlistview() {
        String sql_select = "SELECT * FROM bqt ";
        Cursor cursor = cuoikihelper.SelectData(sql_select);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String verb = cursor.getString(1);
            String past = cursor.getString(2);
            String pii = cursor.getString(3);
            arrayData.add(new verb(verb, past, pii));
        }
        verb_adapter adapter = new verb_adapter(requireContext(), R.layout.item_minh, arrayData);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
