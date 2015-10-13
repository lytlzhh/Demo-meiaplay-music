package com.example.llw.demo_meiaplay_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.MotionEvent;

public class music extends Service {
    private MediaPlayer mediaPlayer;
    public music() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dowok();
            }
        });
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    public  void  dowok(){
        int[] len ={R.raw.d,R.raw.hhe};
        int s = len.length-1;

      if (mediaPlayer!=null)
      {
          mediaPlayer.release();
      }
       mediaPlayer =  MediaPlayer.create(this,len[s--]);
        mediaPlayer.start();
     //  s=s--;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                try {
                    Thread.sleep(3000);
                    dowok();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
