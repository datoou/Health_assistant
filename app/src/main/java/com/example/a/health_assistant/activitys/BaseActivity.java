package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.Course;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends Activity {
    ListView lv;
//    List<Course> course_list;
//    CourseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg_course);

         lv = findViewById(android.R.id.list);
//        initData();
//        adapter = new CourseAdapter(this,course_list);
//        lv.setAdapter(adapter);
    }

//    private void initData(){
//        course_list = new ArrayList<Course>();
//        course_list.add(new Course(R.drawable.a_1,"手臂环绕"));
//        course_list.add(new Course(R.drawable.a_2,"左右小跳"));
//        course_list.add(new Course(R.drawable.a_3,"锯式平板支撑"));
//        course_list.add(new Course(R.drawable.a_4,"早安式体前屈"));
//        course_list.add(new Course(R.drawable.a_5,"箱式深蹲"));
//    }
}
