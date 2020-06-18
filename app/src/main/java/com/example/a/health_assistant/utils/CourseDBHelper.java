package com.example.a.health_assistant.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 21441 on 2020/6/16.
 */

public class CourseDBHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "Course.db";
    private static final String TABLE_NAME = "Course";
    private static final int DB_VERSION = 1;
    public static final String ID="id";
    public static final String COURSE_TITLE="course_title";
    public static final String COURSE_TAG="course_tag";
    public static final String COURSE_INFO="course_info";
    public static final String COURSE_APPLY="course_apply";
    public static final String COURSE_VIDEO="course_video";


    public CourseDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE ="create table if not exists "+TABLE_NAME+" ("
                + ID + " integer primary key,"
                + COURSE_TITLE + " varchar,"
                + COURSE_TAG + " varchar,"
                + COURSE_INFO + " varchar,"
                + COURSE_APPLY + " varchar,"
                + COURSE_VIDEO + " varchar)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
