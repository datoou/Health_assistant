package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a.health_assistant.R;
import com.example.a.health_assistant.utils.CourseDBHelper;

import fm.jiecao.jcvideoplayer_lib.JCUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class CourseInfoActivity extends Activity implements View.OnClickListener {

    private SensorManager sensorManager;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private ImageView iv_back;
    private JCVideoPlayerStandard player;
    private TextView course_title;
    private TextView course_tag;
    private TextView course_info;
    private TextView course_apply;
    CourseDBHelper courseDBHelper;

//    String s1 = "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4";
//    String s2 = "http://player.youku.com/player.php/sid/XMjUyODI2NDc2MA==/v.swf";//不支持swf格式的视频播放
//    String imageUrl = "http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.course_info);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initData() {
        String course_title1 = null;
        String course_tag1 = null;
        String course_info1 = null;
        String course_apply1 = null;
        courseDBHelper = new CourseDBHelper(this);
        Cursor cursor = courseDBHelper.query();
        Intent intent = getIntent();
        int i = intent.getIntExtra("position", -1);
        cursor.moveToPosition(i);
        course_title1 = cursor.getString(cursor.getColumnIndex(CourseDBHelper.COURSE_TITLE));
        course_tag1 = cursor.getString(cursor.getColumnIndex(CourseDBHelper.COURSE_TAG));
        course_info1 = cursor.getString(cursor.getColumnIndex(CourseDBHelper.COURSE_INFO));
        course_apply1 = cursor.getString(cursor.getColumnIndex(CourseDBHelper.COURSE_APPLY));

        course_title.setText(course_title1);
        course_tag.setText(course_tag1);
        course_info.setText(course_info1);
        course_apply.setText(course_apply1);

        //视频
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        //添加视频缩略图
//        ImageView thumbImageView = jcVideoPlayerStandard.thumbImageView;
//        //使用Glide添加
//        Glide.with(this).load(imageUrl).into(thumbImageView);
        //配置jiecaovideoplayer
        cursor.moveToPosition(i);
        String course_video = cursor.getString(cursor.getColumnIndex(CourseDBHelper.COURSE_VIDEO));
        jcVideoPlayerStandard.setUp(course_video, jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
    }

    private void initView() {
        course_title = findViewById(R.id.course_title);
        course_tag = findViewById(R.id.course_tag);
        course_info = findViewById(R.id.course_info);
        course_apply = findViewById(R.id.course_apply);
        iv_back = findViewById(R.id.iv_back);

        iv_back.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
