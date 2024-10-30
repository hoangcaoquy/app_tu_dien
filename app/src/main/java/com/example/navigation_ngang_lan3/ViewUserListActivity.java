package com.example.navigation_ngang_lan3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation_ngang_lan3.dao.UserDAO;
import com.example.navigation_ngang_lan3.model.User;

import java.util.ArrayList;
import java.util.List;

public class ViewUserListActivity extends AppCompatActivity {
    ListView listView;
    UserArrayAdapter arrayAdapter;
    List<User> userList = new ArrayList<>();
    Context context;
    UserDAO userDAO;
    private int contextMenuItemPosition = -1; // Sử dụng biến riêng cho menu ngữ cảnh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_list);
        context = this;
        listView = findViewById(R.id.lv_user);
        userDAO = new UserDAO(context);
        userList = userDAO.getAllClass();

        arrayAdapter = new UserArrayAdapter(context, userList);

        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 0, 0, "Xóa");
        contextMenuItemPosition = ((AdapterView.AdapterContextMenuInfo) menuInfo).position; // Lấy vị trí của mục được chọn
        menu.add(Menu.NONE, 1, 1, "Sửa");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                if (contextMenuItemPosition >= 0 && contextMenuItemPosition < userList.size()) {
                    User selectedUser = userList.get(contextMenuItemPosition);
                    String userId = selectedUser.getId();

                    int deletedRows = userDAO.deleteUser(userId);
                    if (deletedRows > 0) {
                        userList.remove(selectedUser);
                        arrayAdapter.notifyDataSetChanged();
                        Toast.makeText(ViewUserListActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ViewUserListActivity.this, "Không thể xóa", Toast.LENGTH_LONG).show();
                    }
                }
                return true;
            case 1:
                if (contextMenuItemPosition >= 0 && contextMenuItemPosition < userList.size()) {
                    User selectedUser = userList.get(contextMenuItemPosition);

                    // Chuyển sang hoạt động sửa với thông tin người dùng đã chọn
                    Intent editIntent = new Intent(this, EditUserActivity.class);
                    editIntent.putExtra("selected_user", selectedUser);
                    startActivity(editIntent);
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // Hàm này được gọi sau khi quay lại từ hoạt động sửa
    @Override
    protected void onResume() {
        super.onResume();
        // Tải lại danh sách người dùng sau khi quay lại
        userList = userDAO.getAllClass();
        arrayAdapter = new UserArrayAdapter(context, userList);
        listView.setAdapter(arrayAdapter);
    }
}

