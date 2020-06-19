package com.example.a.health_assistant.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.App;

import java.util.List;

/**
 * Created by 大大大荣 on 2020/4/15.
 */

public class MyAdapter extends BaseAdapter {

    private List<App> list;
    private Context context;
    private  TextView foodName;

    public MyAdapter(List<App> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();

            holder.food_name=convertView.findViewById(R.id.foodView);
            holder.hirView=convertView.findViewById(R.id.hidView);
            holder.tView=convertView.findViewById(R.id.tView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        App app = list.get(position);

        holder.food_name.setText(app.getName());
        holder.hirView.setText(app.getHir());
        holder.tView.setText(app.getT());
        return  convertView;

    }


    class ViewHolder{
        TextView food_name;
        TextView tView;
        TextView hirView;


    }
}
