package vaje.si.fri.emp.zdravila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPogledZdravil(View v){
        Intent intent = new Intent(MainActivity.this,
                PogledZdravil.class);
        startActivity(intent);
    }
    public void onClickAlarmActivity(View v){
        Intent intent = new Intent(MainActivity.this,
                AlarmActivity.class);
       startActivity(intent);
    }
    public void onClickPogledZdravilTest(View v){
        Intent intent = new Intent(MainActivity.this,
                PogledZdravil2.class);
        startActivity(intent);
    }
}
