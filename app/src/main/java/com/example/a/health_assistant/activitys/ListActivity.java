package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.Course;

import java.util.List;

public class ListActivity extends Activity {
    List<Course> course_list;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg_course);

        lv = findViewById(android.R.id.list);
    }
}
