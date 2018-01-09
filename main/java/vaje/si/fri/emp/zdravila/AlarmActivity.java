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
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    private EditText ET;
    private Button button;
    private TimePicker timep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        ET=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        timep=(TimePicker)findViewById(R.id.timePicker);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int time= Integer.parseInt(ET.getText().toString());

                Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, 0);
                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                //manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000*time,pendingIntent);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                if (Build.VERSION.SDK_INT >= 23 ){
                    calendar.set(Calendar.HOUR_OF_DAY, timep.getHour());
                    calendar.set(Calendar.MINUTE, timep.getMinute());
                    manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                    Toast.makeText(AlarmActivity.this, "Alarm Set at "+Integer.toString(timep.getHour())+":"
                            +Integer.toString(timep.getMinute())+" ", Toast.LENGTH_SHORT).show();
                }
                else{
                    calendar.set(Calendar.HOUR_OF_DAY, timep.getCurrentHour());
                    calendar.set(Calendar.MINUTE, timep.getCurrentMinute());

                    manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                    Toast.makeText(AlarmActivity.this, "Alarm Set at "+Integer.toString(timep.getCurrentHour())+":"
                            +Integer.toString(timep.getCurrentMinute())+" ", Toast.LENGTH_SHORT).show();
                }

                //calendar.set(Calendar.HOUR_OF_DAY, 18);
                //calendar.set(Calendar.MINUTE, 32);



            }
        });
    }
}
