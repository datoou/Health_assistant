package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.App;
import com.example.a.health_assistant.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends Activity {

    private ListView listview;
    private List<App> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_food);
        init();

        //创建 Adapter
        MyAdapter myadapter = new MyAdapter(list,this);

        //讲Adapter
        listview.setAdapter(myadapter);
    }

    private void init() {
        listview = (ListView)findViewById(R.id.listview);
        // 初始化数据
        list = new ArrayList<App>();
        list.add(new App("豆汁","10.0Kcal","推荐"));
        list.add(new App("玉米笋","16.0Kcal","推荐"));
        list.add(new App("小米粥","46.0Kcal","推荐"));
        list.add(new App("烧饼","330.0Kcal","可适量"));
        list.add(new App("豆沙包","240.0Kcal","要长肉"));


    }
}
