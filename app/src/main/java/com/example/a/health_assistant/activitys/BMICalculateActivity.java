package com.example.a.health_assistant.activitys;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.health_assistant.R;

import java.math.BigDecimal;

public class BMICalculateActivity extends Activity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private TextView tv_bmi;
    private TextView tv_IdealWeight;
    private TextView tv01a;
    private TextView tv01b;
    private TextView tv02a;
    private TextView tv02b;
    private TextView tv03a;
    private TextView tv03b;
    private TextView tv04a;
    private TextView tv04b;
    private TextView tv05a;
    private TextView tv05b;
    private ImageButton imgbutton;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.bmi_calculate_actvivty);
        init();
    }

    public void init() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv_bmi = findViewById(R.id.tv_bmi);
        tv_IdealWeight = findViewById(R.id.tv_IdealWeight);
        iv_back = findViewById(R.id.iv_back);
        imgbutton = findViewById(R.id.imgbutton);
        tv01a = findViewById(R.id.tv01a);
        tv01b = findViewById(R.id.tv01b);
        tv02a = findViewById(R.id.tv02a);
        tv02b = findViewById(R.id.tv02b);
        tv03a = findViewById(R.id.tv03a);
        tv03b = findViewById(R.id.tv03b);
        tv04b = findViewById(R.id.tv04a);
        tv04a = findViewById(R.id.tv04b);
        tv05a = findViewById(R.id.tv05a);
        tv05b = findViewById(R.id.tv05b);


        imgbutton.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbutton:
                String x = String.valueOf(et1.getText().toString());
                String y = String.valueOf(et2.getText().toString());
                if (x.length() <= 0 & y.length() <= 0) {
                    Toast.makeText(this, "请输入身高和体重", Toast.LENGTH_SHORT).show();
                } else if (x.length() <= 0 & y.length() > 0) {
                    Toast.makeText(this, "请输入身高", Toast.LENGTH_SHORT).show();
                } else if (x.length() > 0 & y.length() <= 0) {
                    Toast.makeText(this, "请输入体重", Toast.LENGTH_SHORT).show();
                } else if (x.length() > 0 & y.length() > 0) {

                    Resources myColor = getBaseContext().getResources();
                    Drawable color_A = myColor.getDrawable(R.color.zdfp);
                    Drawable color_B = myColor.getDrawable(R.color.bottom_bg);
                    Drawable color_C = myColor.getDrawable(R.color.jdps);
                    Drawable color_D = myColor.getDrawable(R.color.zc);
                    Drawable color_E = myColor.getDrawable(R.color.pp);
                    Drawable color_F = myColor.getDrawable(R.color.fp);

                    double Height, Weight;
                    Weight = Double.valueOf(et2.getText().toString());
                    Height = Double.valueOf(et1.getText().toString());

                    double a = Height / 100;
                    double BMI = new BigDecimal(Weight / (a * a)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    double Idealmin = new BigDecimal(22 * a * a - 22 * a * a * 0.1).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    double Idealmax = new BigDecimal(22 * a * a + 22 * a * a * 0.1).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

                    tv_bmi.setText("BMI:" + BMI);
                    tv_IdealWeight.setText("理想体重：" + Idealmin + "kg-" + Idealmax + "kg");

                    tv01a.setBackgroundDrawable(color_B);
                    tv01b.setBackgroundDrawable(color_B);
                    tv02a.setBackgroundDrawable(color_B);
                    tv02b.setBackgroundDrawable(color_B);
                    tv03a.setBackgroundDrawable(color_B);
                    tv03b.setBackgroundDrawable(color_B);
                    tv04a.setBackgroundDrawable(color_B);
                    tv04b.setBackgroundDrawable(color_B);
                    tv05a.setBackgroundDrawable(color_B);
                    tv05b.setBackgroundDrawable(color_B);


                    if (BMI > 0 & BMI < 18.5) {
                        tv01a.setBackgroundDrawable(color_C);
                        tv01b.setBackgroundDrawable(color_C);
                    } else if (BMI >= 18.5 & BMI <= 23.9) {
                        tv02a.setBackgroundDrawable(color_D);
                        tv02b.setBackgroundDrawable(color_D);
                    } else if (BMI >= 24 & BMI <= 26.9) {
                        tv03a.setBackgroundDrawable(color_E);
                        tv03b.setBackgroundDrawable(color_E);
                    } else if (BMI >= 27 & BMI <= 29.9) {
                        tv04a.setBackgroundDrawable(color_F);
                        tv04b.setBackgroundDrawable(color_F);
                    } else if (BMI >= 30) {
                        tv05a.setBackgroundDrawable(color_A);
                        tv05b.setBackgroundDrawable(color_A);
                    }
                }
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
        }

    }
}
