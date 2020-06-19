package com.example.a.health_assistant.activitys;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.a.health_assistant.R;

public class MyService extends Service {
    private final static String TAG = "Myservice";
    private MediaPlayer mediaPlayer = null;
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sleep);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(MyService.this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this,0,intent1,0);
        Notification notification = new Notification.Builder(MyService.this).setContentTitle("该去训练了~").setContentText("冲冲冲！！！").
                setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.smallicon1).setAutoCancel(true).setContentIntent(pendingIntent).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo1)).build();
        manager.notify(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Log.i(TAG,"onDestroy()");
    }
}
