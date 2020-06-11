package com.example.a.health_assistant.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.a.health_assistant.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class CourseInfoActivity extends Activity {

    private String videoUrl = "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4";
    private JCVideoPlayerStandard player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.course_info);
        JCVideoPlayerStandard player = (JCVideoPlayerStandard) findViewById(R.id.player_list_video);
        boolean setUp = player.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4", JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(CourseInfoActivity.this).load("http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg")
                    .into(player.thumbImageView);
        }
//        //直接进入全屏
//        player.startFullscreen(this, JCVideoPlayerStandard.class, videoUrl, "");
//        //模拟用户点击开始按钮，NORMAL状态下点击开始播放视频，播放中点击暂停视频
//        player.startButton.performClick();

    }


    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
