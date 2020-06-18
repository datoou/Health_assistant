package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.User;
import com.example.a.health_assistant.utils.UserDBHelper;

public class RegisterActivity extends Activity implements View.OnClickListener {

    private Button btn_register;
    private EditText et_username;
    private EditText et_password;
    private EditText et_input;
    UserDBHelper userDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_register);
        initView();
        initData();
    }


    @Override
    public void onClick(View v) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String repassword = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_register:
                if (username == null || username.equals("") || password == null || password.equals("")
                        || repassword == null || repassword.equals("")) {
                    Toast.makeText(this, "您的输入有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!repassword.equals(password)) {
                    Toast.makeText(this, "两次输入不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userDBHelper.CheckIsDataAlreadyInDBorNot(username)) {
                    Toast.makeText(this, "该用户名已被注册，注册失败", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(username, password);
                    userDBHelper.insert(user);
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }


    }

    private void initData() {
        userDBHelper = new UserDBHelper(this);
    }

    private void initView() {
        btn_register = findViewById(R.id.btn_register);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_input = findViewById(R.id.et_input);

        btn_register.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDBHelper.close();
    }
}
