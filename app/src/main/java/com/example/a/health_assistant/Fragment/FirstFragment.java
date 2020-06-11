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
        int[] images = {R.drawable.b_1,R.drawable.b_2,R.drawable.a_3,R.drawable.a_4,R.drawable.a_5,
                R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4,R.drawable.a_5,
                R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4,R.drawable.a_5};
        //内容
        String[] names = {"手臂环绕","左右小跳","锯式平板支撑","早安式体前屈","箱式深蹲","手臂环绕","左右小跳","锯式平板支撑","早安式体前屈","箱式深蹲",
                "手臂环绕","左右小跳","锯式平板支撑","早安式体前屈","箱式深蹲"};
        //参数一：上下文对象  参数二：数据源List<Map<String,Object>> 参数三：item对应的布局文件
        //参数四：表示由map中定义的key组成的字符串类型的数字  参数五：需要显示的控件id组成的的数组
        //保证参数四和参数五一一对应，否则控件属性会对换（张冠李戴）
        adapter = new SimpleAdapter(getActivity(), getData(images,names),
                R.layout.course_item, new String[] { "img", "name" },
                new int[] { R.id.course_bg, R.id.course_name });
        //继承了ListFragment后的方法
        setListAdapter(adapter);
//        AdapterView.OnItemClickListener itemClick  = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (parent.getId())
//                {
//                    case android.R.id.list://listView是xml中的id
//                        expressitemClick(position);//position 代表你点的哪一个
//                        break;
//                }
//            }
//            public void expressitemClick(int postion){
//                Intent intent = new Intent(getActivity(),CourseInfoActivity.class);//从fragment中跳转到Activity中
//                startActivity(intent);
//                //  finish();//看你需不需要返回当前界面，如果点返回需要返回到当前界面，就不用这个
//            }
//        };
//        lv.setOnItemClickListener(itemClick);

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
