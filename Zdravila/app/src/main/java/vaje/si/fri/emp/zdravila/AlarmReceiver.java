package vaje.si.fri.emp.zdravila;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Window;
import android.widget.Toast;


/**
 * Created by zp5394 on 8. 01. 2018.
 */

public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        //wake the screen
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        wl.acquire();

        //message
        Toast.makeText(context, "Opomnik za zdravila", Toast.LENGTH_LONG).show();

        //stop po 10 sec
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ringtone.stop();
            }
        }, 10000);

    }
}
