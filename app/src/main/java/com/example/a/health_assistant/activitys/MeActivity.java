package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.utils.UserDBHelper;

public class MeActivity extends Activity{

    private TextView tv_user;
    UserDBHelper userDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.me_activity);
        initView();
        initData();
    }

    private void initView(){
        tv_user = findViewById(R.id.tv_user);
    }
    private void initData(){
        }
}