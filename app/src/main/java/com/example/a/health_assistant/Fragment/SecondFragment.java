package com.example.a.health_assistant.Fragment;


import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.activitys.MyService;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class SecondFragment extends Fragment implements View.OnClickListener{

    private Button remind_open;
    private Button remind_close;
    private EditText et_time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_remind,container,false);
        remind_open = view.findViewById(R.id.remind_open);
        remind_close = view.findViewById(R.id.remind_close);
        et_time = view.findViewById(R.id.et_time);

        remind_open.setOnClickListener(this);
        remind_close.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remind_open:
                String time1 = et_time.getText().toString();
                if (time1.equals("") || time1 == null){
                    Toast.makeText(getActivity(),"您的输入有误",Toast.LENGTH_SHORT).show();
                }else {
                int time = Integer.parseInt(et_time.getText().toString());
                Intent intent = new Intent(getActivity(),MyService.class);
                PendingIntent pIntent = PendingIntent.getService(getActivity(), 0, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                // 从系统服务中获取闹钟管理器
                AlarmManager alarmMgr = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                // 设置系统时间
                calendar.setTimeInMillis(System.currentTimeMillis());
                // 给当前时间加上若干秒，这里时间单位是 秒
                calendar.add(Calendar.SECOND, time);
                alarmMgr.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pIntent);
                Toast.makeText(getActivity(),"设置成功,将在"+time+"秒后响铃",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remind_close:
                Intent intent1 = new Intent(getActivity(),MyService.class);
                Toast.makeText(getActivity(),"已关闭提醒",Toast.LENGTH_SHORT).show();
                getActivity().stopService(intent1);
                break;
        }
    }
}
