package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.a.health_assistant.Fragment.FirstFragment;
import com.example.a.health_assistant.Fragment.SecondFragment;
import com.example.a.health_assistant.Fragment.ThirdFragment;
import com.example.a.health_assistant.R;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView tv_course;
    private TextView tv_remind;
    private TextView tv_food;
    private FrameLayout ly_content;

    //Fragment Object
    private FirstFragment fg_course;
    private SecondFragment fg_remind;
    private ThirdFragment fg_food;

    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        tv_course.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        tv_course = (TextView) findViewById(R.id.tv_course);
        tv_remind = (TextView) findViewById(R.id.tv_remind);
        tv_food = (TextView) findViewById(R.id.tv_food);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        tv_course.setOnClickListener(this);
        tv_remind.setOnClickListener(this);
        tv_food.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        tv_course.setSelected(false);
        tv_remind.setSelected(false);
        tv_food.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg_course != null)fragmentTransaction.hide(fg_course);
        if(fg_remind != null)fragmentTransaction.hide(fg_remind);
        if(fg_food != null)fragmentTransaction.hide(fg_food);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tv_course:
                setSelected();
                tv_course.setSelected(true);
                if(fg_course == null){
                    fg_course = new FirstFragment();
                    fTransaction.add(R.id.ly_content,fg_course);
                }else{
                    fTransaction.show(fg_course);
                }
                break;
            case R.id.tv_remind:
                setSelected();
                tv_remind.setSelected(true);
                if (fg_remind == null) {
                    fg_remind = new SecondFragment();
                    fTransaction.add(R.id.ly_content, fg_remind);
                }else{
                    fTransaction.show(fg_remind);
                }
                break;
            case R.id.tv_food:
                setSelected();
                tv_food.setSelected(true);
                if(fg_food == null){
                    fg_food = new ThirdFragment();
                    fTransaction.add(R.id.ly_content,fg_food);
                }else{
                    fTransaction.show(fg_food);
                }
                break;
        }
        fTransaction.commit();
    }
}
