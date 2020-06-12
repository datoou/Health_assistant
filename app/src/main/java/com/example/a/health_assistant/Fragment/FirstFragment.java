package com.example.a.health_assistant.Fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.activitys.CourseInfoActivity;
import com.example.a.health_assistant.activitys.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstFragment extends ListFragment {

    ListView lv;
    SimpleAdapter  adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //图片
        int[] images = {R.drawable.b_1,R.drawable.b_2,R.drawable.b_3,R.drawable.b_4,R.drawable.b_5,
                R.drawable.b_1,R.drawable.b_6,R.drawable.b_7,R.drawable.b_8,R.drawable.b_1,
                R.drawable.b_2,R.drawable.b_3,R.drawable.b_4,R.drawable.b_5,R.drawable.b_6};
        //内容
        String[] names = {"徒手胸部训练初级","器械训练中级","HIIT适应上肢充能","徒手胸部训练中级","拳击训练初级",
                "徒手胸部训练初级","器械训练中级","HIIT适应上肢充能","徒手胸部训练中级","拳击训练初级"
        ,"徒手胸部训练初级","器械训练中级","HIIT适应上肢充能","徒手胸部训练中级","拳击训练初级"};
        //参数一：上下文对象  参数二：数据源List<Map<String,Object>> 参数三：item对应的布局文件
        //参数四：表示由map中定义的key组成的字符串类型的数字  参数五：需要显示的控件id组成的的数组
        //保证参数四和参数五一一对应，否则控件属性会对换（张冠李戴）
        adapter = new SimpleAdapter(getActivity(), getData(images,names),
                R.layout.course_item, new String[] { "img", "name" },
                new int[] { R.id.course_bg, R.id.course_name });
        //继承了ListFragment后的方法
        setListAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_course,container,false);
        lv = view.findViewById(android.R.id.list);
//        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
//        txt_content.setText(content);
        return view;
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(position == 0){
            Intent intent = new Intent(getActivity(),CourseInfoActivity.class);
            startActivity(intent);
            Toast.makeText(getActivity(),"你点击了 消息中心",Toast.LENGTH_LONG).show();
        }else if(position == 1){
            Toast.makeText(getActivity(),"你点击了  家教记录",Toast.LENGTH_LONG).show();
        }else if(position == 2){
            Toast.makeText(getActivity(),"你点击了  设置",Toast.LENGTH_LONG).show();
        }
        super.onListItemClick(l, v, position, id);
    }

    private List<? extends Map<String, ?>> getData(int[] images, String[] names) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", images[i]);
            map.put("name", names[i]);
            list.add(map);
        }

        return list;
    }
}
