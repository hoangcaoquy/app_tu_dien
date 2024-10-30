package com.example.navigation_ngang_lan3.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.navigation_ngang_lan3.database.SQLite;
import com.example.navigation_ngang_lan3.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static final String TAG = UserDAO.class.getSimpleName();
    private SQLiteDatabase db;
    private SQLite dbhelper;
    private Context context;

    public UserDAO(Context context) {
        this.context = context;
        dbhelper = new SQLite(context);
        db = dbhelper.getWritableDatabase();
    }
    // Insert dữ liệu
    public long insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", user.getId());
        contentValues.put("name", user.getName());
        long result = db.insertWithOnConflict("USERS", null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        if (result <= 0) {
            Log.e(TAG, "Insert failed");
        }
        return result;
    }
    @SuppressLint("Range")
    public List<User> getAllClass() {
        List<User> userList = new ArrayList<>();
        Cursor c = db.query("USERS", null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            User user = new User();
            user.setId(c.getString(0));
            user.setName(c.getString(1));
            userList.add(user);
            c.moveToNext();
        }
        c.close();
        return userList; // Trả về danh sách người dùng
    }
    public int deleteUser(String id) {
        int result = db.delete("USERS", "id=?", new String[]{id});
        if (result <= 0) {
            Log.e(TAG, "Delete failed");
        }
        return result;
    }
    // Lấy danh sách tên người dùng
    @SuppressLint("Range")
    public List<String> getUserNames() {
        List<String> userNameList = new ArrayList<>();
        Cursor c = db.query("USERS", null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            User user = new User();
            user.setName(c.getString(c.getColumnIndex("name")));
            userNameList.add(user.getName());
            c.moveToNext();
        }
        c.close();
        return userNameList;
    }
    public long updateUser(User selectedUser) {
        ContentValues values = new ContentValues();
        values.put("name", selectedUser.getName());
        String selection = "id = ?";
        String[] selectionArgs = {selectedUser.getId()};
        long result = db.update("USERS", values, selection, selectionArgs);
        if (result <= 0) {
            Log.e(TAG, "Update failed");
        }
        return result;
    }
}
