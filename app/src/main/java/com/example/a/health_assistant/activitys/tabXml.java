package com.example.a.health_assistant.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.a.health_assistant.R;
import com.example.a.health_assistant.User.App;
import com.example.a.health_assistant.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class tabXml extends FoodActivity implements View.OnClickListener{
    private TabHost myHost;
    private ListView lv_foodfirst,lv_foodsecond,lv_foodthroee;
    private List<App> list1,list2,list3;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定布局
        setContentView(R.layout.layout_tabxml);

       // 绑定控件
        myHost = (TabHost) findViewById(R.id.tabhost);
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        //
        myHost.setup();
        //设置tab的内容
        myHost.addTab(myHost.newTabSpec("tab1").setIndicator("碳水化合物",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.tabfirst));
        myHost.addTab(myHost.newTabSpec("tab2").setIndicator("蛋白质",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.tabSecond));
        myHost.addTab(myHost.newTabSpec("tab3").setIndicator("脂肪",getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.tabthroee));
        init1();
        init2();
        init3();
        //创建 Adapter
        MyAdapter myadapter1 = new MyAdapter(list1,this);
        MyAdapter myadapter2 = new MyAdapter(list2,this);
        MyAdapter myadapter3 = new MyAdapter(list3,this);
//        Adapter
        lv_foodfirst.setAdapter(myadapter1);
        lv_foodsecond.setAdapter(myadapter2);
        lv_foodthroee.setAdapter(myadapter3);




}


    private void init1() {

        lv_foodfirst = (ListView)findViewById(R.id.listview1);

        // 初始化数据
        list1 = new ArrayList<App>();
        list1.add(new App("豆汁","10.0Kcal","推荐"));
        list1.add(new App("玉米笋","16.0Kcal","推荐"));
        list1.add(new App("小米粥","46.0Kcal","推荐"));
        list1.add(new App("紫薯","80.0Kcal","推荐"));
        list1.add(new App("红薯","83.4Kcal","推荐"));
        list1.add(new App("白薯","106.0Kcal","推荐"));
        list1.add(new App("烧饼","330.0Kcal","可适量"));
        list1.add(new App("面包","312.0Kcal","可适量"));
        list1.add(new App("粉条","338.0Kcal","可适量"));
        list1.add(new App("豆沙包","240.0Kcal","要长肉"));
        list1.add(new App("烧卖","243.0Kcal","要长肉"));


    }
    private void init2(){
        lv_foodsecond=findViewById(R.id.listview2);
        // 初始化数据
        list2 = new ArrayList<App>();
        list2.add(new App("豆腐脑","15.0Kcal","推荐"));
        list2.add(new App("豆浆","31.0Kcal","推荐"));
        list2.add(new App("海蜇皮","33.0Kcal","推荐"));
        list2.add(new App("鸡血","49.0Kcal","推荐"));
        list2.add(new App("章鱼","52.0Kcal","推荐"));
        list2.add(new App("猪血","55.0Kcal","推荐"));
        list2.add(new App("羊奶","59.0Kcal","推荐"));
        list2.add(new App("酸奶","72.0Kcal","可适量"));
        list2.add(new App("牛肚","72.0Kcal","可适量"));
        list2.add(new App("猪脊","96.0Kcal","可适量"));
        list2.add(new App("瘦牛肉","106.0Kcal","可适量"));
        list2.add(new App("油豆腐","245.0Kcal","要长肉"));
        list2.add(new App("酱牛肉","246.0Kcal","要长肉"));
        list2.add(new App("猪蹄","266.0Kcal","要长肉"));
    }
    private void init3(){
        lv_foodthroee=findViewById(R.id.listview3);
        // 初始化数据
        list3 = new ArrayList<App>();
        list3.add(new App("菠萝蜜籽","165.0Kcal","推荐"));
        list3.add(new App("板栗","188.0Kcal","推荐"));
        list3.add(new App("鲜核桃","336.0Kcal","推荐"));
        list3.add(new App("巴旦木","514.0Kcal","推荐"));
        list3.add(new App("腰果","566.0Kcal","推荐"));
        list3.add(new App("西瓜子","582.0Kcal","推荐"));
        list3.add(new App("南瓜子","582.0Kcal","推荐"));
        list3.add(new App("炒瓜子","601.0Kcal","推荐"));
        list3.add(new App("松子仁","698.0Kcal","推荐"));
        list3.add(new App("白果","355.0Kcal","可适量"));
        list3.add(new App("玉米油","895.0Kcal","可适量"));
        list3.add(new App("芝麻油","899.0Kcal","可适量"));
        list3.add(new App("猪油","897.0Kcal","要长肉"));
        list3.add(new App("牛油","898.0Kcal","要长肉"));
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }

}
