package com.example.a.health_assistant.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a.health_assistant.User.User;

/**
 * Created by 21441 on 2020/6/15.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "User.db";
    private static final String TABLE_NAME = "Users";
    private static final int DB_VERSION = 1;
    public static final String ID="id";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";


    public UserDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE ="create table if not exists "+TABLE_NAME+" ("
                + ID + " integer primary key,"
                + USERNAME + " varchar,"
                + PASSWORD + " varchar)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //用户注册
    public void insert(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserDBHelper.USERNAME,user.getUsername() );
        values.put(UserDBHelper.PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    //修改密码
    public void update(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserDBHelper.USERNAME,user.getUsername());
        values.put(UserDBHelper.PASSWORD,user.getPassword());
        db.update(TABLE_NAME,values,USERNAME+"=?",new String[]{user.getUsername()});
        db.close();
    }
    //修改密码验证
    public boolean CheckIsDataOldpassword(String value) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,USERNAME,PASSWORD}, "password=?",new String[]{value}, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
    //登录验证
    public boolean CheckIsDataAlreadyInDBorNot(String value) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,USERNAME,PASSWORD}, "username=?",new String[]{value}, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
    //登录
    public boolean login(String username,String password) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,USERNAME,PASSWORD},"username=? and password=?",
                new String[]{username,password}, null, null, null);
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

}
