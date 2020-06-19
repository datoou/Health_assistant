package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.User;
import com.example.a.health_assistant.utils.UserDBHelper;

public class ModifyPasswordActivity extends Activity implements View.OnClickListener{

    private ImageView iv_back;
    private EditText input_old_password;
    private EditText input_password;
    private EditText input_password_confirm;
    private Button btn_sure;
    UserDBHelper userDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
        initData();
    }

    private void initView(){
        iv_back = findViewById(R.id.iv_back);
        input_old_password = findViewById(R.id.input_old_password);
        input_password = findViewById(R.id.input_password);
        input_password_confirm = findViewById(R.id.input_password_confirm);
        btn_sure = findViewById(R.id.btn_sure);

        iv_back.setOnClickListener(this);
        btn_sure.setOnClickListener(this);
    }
    private void initData() {
        userDBHelper = new UserDBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String newpassword = input_password.getText().toString();
        String oldpassword = input_old_password.getText().toString();
        String confirmpassword = input_password_confirm.getText().toString();
        switch (v.getId()){
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_sure:
                if (newpassword == null || newpassword.equals("") || oldpassword == null || oldpassword.equals("")
                        || confirmpassword == null || confirmpassword.equals("")) {
                    Toast.makeText(this, "您的输入有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newpassword.equals(confirmpassword)) {
                    Toast.makeText(this, "两次输入不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!userDBHelper.CheckIsDataOldpassword(oldpassword)) {
                    Toast.makeText(this, "原密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);
                    String username = sp.getString("username", "");
                    User user = new User(username, newpassword);
                    userDBHelper.update(user);
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
