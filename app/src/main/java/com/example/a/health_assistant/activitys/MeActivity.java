package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.health_assistant.R;

public class MeActivity extends Activity implements View.OnClickListener{
    private TextView mTvuser;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.me_activity);
        initView();
    }

    private void initView() {
        iv_back = findViewById(R.id.iv_back);


        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.iv_back:
//                onBackPressed();
//                break;
//            case R.id.exit:
//                Intent intent = new Intent(MeActivity.this,LoginActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.bmi_calculate:
//                Intent intent1 = new Intent(this,BMICalculateActivity.class);
//                startActivity(intent1);
        }

    }
}