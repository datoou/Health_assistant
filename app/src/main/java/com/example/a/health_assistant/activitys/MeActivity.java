package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.a.health_assistant.R;

public class MeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.me_activity);
    }

}