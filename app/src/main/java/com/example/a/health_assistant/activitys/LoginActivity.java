package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.utils.UserDBHelper;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText et_username_login;
    private EditText et_password_login;
    private Button btn_login;
    private TextView btn_register;
    UserDBHelper userDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);

        initView();
        initData();
    }


    private void initView() {
        et_username_login = findViewById(R.id.et_username_login);
        et_password_login = findViewById(R.id.et_password_login);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    private void initData() {
        userDBHelper = new UserDBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String username = et_username_login.getText().toString();
        String password = et_password_login.getText().toString();
        switch (v.getId()) {
            case R.id.btn_login:
                if (username == null || username.equals("") || password == null || password.equals("")) {
                    Toast.makeText(this, "您的输入有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userDBHelper.login(username, password)) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_register:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }

}
