package vaje.si.fri.emp.zdravila;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {


    private Button button;
    private TimePicker timep;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        button=(Button)findViewById(R.id.button);
        timep=(TimePicker)findViewById(R.id.timePicker);
        spinner=(Spinner)findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //

                String when=spinner.getSelectedItem().toString();


                Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, 0);
                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                //

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                if (Build.VERSION.SDK_INT >= 23 ){
                    calendar.set(Calendar.HOUR_OF_DAY, timep.getHour());
                    calendar.set(Calendar.MINUTE, timep.getMinute());
                    manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                    Toast.makeText(AlarmActivity.this, "Alarm Set at "+Integer.toString(timep.getHour())+":"
                            +Integer.toString(timep.getMinute())+" "+when, Toast.LENGTH_SHORT).show();
                }
                else{
                    calendar.set(Calendar.HOUR_OF_DAY, timep.getCurrentHour());
                    calendar.set(Calendar.MINUTE, timep.getCurrentMinute());

                    manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                    Toast.makeText(AlarmActivity.this, "Alarm Set at "+Integer.toString(timep.getCurrentHour())+":"
                            +Integer.toString(timep.getCurrentMinute())+" "+when, Toast.LENGTH_SHORT).show();
                }

                if(when.equals("Daily"))
                    manager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                else if(when.equals("Weekly"))
                    manager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7,pendingIntent);
                else
                    manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);





            }
        });
    }
}
