package com.example.a.health_assistant.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.Course;

import java.util.List;

/**
 * Created by 21441 on 2020/6/10.
 */

public class CourseAdapter extends BaseAdapter {

    private Context context;
    private List<Course> course_list;

    public CourseAdapter(Context context, List<Course> course_list) {
        this.context = context;
        this.course_list = course_list;
    }

    @Override
    public int getCount() {
        return course_list.size();
    }

    @Override
    public Object getItem(int i) {
        return course_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = View.inflate(context, R.layout.course_item,null);
        ImageView imageVIew = itemView.findViewById(R.id.course_bg);
        TextView course_name = itemView.findViewById(R.id.course_name);
        imageVIew.setImageResource(course_list.get(i).getCourseImage());
        course_name.setText(course_list.get(i).getCourseName());
        return itemView;
    }
}
