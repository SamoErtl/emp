package vaje.si.fri.emp.zdravila;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jjmse on 10/01/2018.
 */

public class ComperActivity extends AppCompatActivity{
    Button button;
    Spinner spinner1;
    Spinner spinner2;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comper_act);

        button=(Button)findViewById(R.id.button);
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        textview=(TextView)findViewById(R.id.textView);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ComperActivity.this, Comperator.class);
                Bundle bundle = new Bundle();
                bundle.putString("med1",spinner1.getSelectedItem().toString());
                bundle.putString("med2",spinner2.getSelectedItem().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                textview.setText(data.getStringExtra("result"));
            }else
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}