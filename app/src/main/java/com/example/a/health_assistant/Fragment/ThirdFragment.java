package com.example.a.health_assistant.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.activitys.BMICalculateActivity;
import com.example.a.health_assistant.activitys.FoodActivity;
import com.example.a.health_assistant.activitys.LoginActivity;
import com.example.a.health_assistant.activitys.ModifyPasswordActivity;
import com.example.a.health_assistant.activitys.tabXml;

public class ThirdFragment extends Fragment{
    private Button exit;
    private Button bmi_calculate;
    private TextView tv_user;
    private Button tv_modify_password;
    private Button btn_food;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_me,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bmi_calculate = getActivity().findViewById(R.id.bmi_calculate);
        exit = getActivity().findViewById(R.id.exit);
        tv_user = getActivity().findViewById(R.id.tv_user);
        tv_modify_password = getActivity().findViewById(R.id.tv_modify_password);
        btn_food = getActivity().findViewById(R.id.btn_food);

        SharedPreferences sp = getActivity().getSharedPreferences("username",Context.MODE_PRIVATE);
        String username = sp.getString("username","");
        tv_user.setText("欢迎您，"+username);


        bmi_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BMICalculateActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        tv_modify_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModifyPasswordActivity.class);
                startActivity(intent);
            }
        });
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),tabXml.class);
                startActivity(intent);
            }
        });
    }
}
