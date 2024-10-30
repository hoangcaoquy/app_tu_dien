package com.example.navigation_ngang_lan3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {
    // Tên cơ sở dữ liệu
    public static final String DATABASE_NAME = "USERMANAGE.db";

    // Phiên bản cơ sở dữ liệu
    public static final int DATABASE_VERSION = 1;

    // Tên bảng và các trường dữ liệu
    public static final String TABLE_USERS = "USERS";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE = "phone";

    // Câu lệnh SQL để tạo bảng người dùng
    public static final String SQL_CREATE_USERS = "CREATE TABLE " + TABLE_USERS + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_USERNAME + " TEXT, " +
            COLUMN_PASSWORD + " TEXT, " +
            COLUMN_ADDRESS + " TEXT, " +
            COLUMN_PHONE + " TEXT)";
    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USERS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }
}
