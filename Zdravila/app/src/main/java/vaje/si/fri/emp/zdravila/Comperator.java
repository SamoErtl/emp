package vaje.si.fri.emp.zdravila;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jjmse on 10/01/2018.
 */


public class Comperator extends AppCompatActivity {
    TextView medicine1;
    TextView medicine2;
    EditText weight1;
    EditText weight2;
    Button compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comperer);

        medicine1=(TextView)findViewById(R.id.medicine1);
        medicine2=(TextView)findViewById(R.id.medicine2);
        weight1=(EditText)findViewById(R.id.weight1);
        weight2=(EditText)findViewById(R.id.weight2);
        compare=(Button)findViewById(R.id.compare);




        final Map<String, Double> map=new HashMap<String, Double>();
        map.put("Lekadol",0.015);
        map.put("Lekadol plus C",0.02);
        map.put("Diverin",0.03);
        map.put("Angal",0.012);
        map.put("Operil",0.01);
        map.put("Fluimukan",0.022);
        map.put("Linex",0.04);
        map.put("Neopersen",0.035);

        String med1="";
        String med2="";
        final Intent intent = getIntent();
        if (intent != null) {
            final Bundle bundle = intent.getExtras();
            med1 = bundle.getString("med1");
            med2 = bundle.getString("med2");
            medicine1.setText(med1);
            medicine2.setText(med2);
        }

        final String finalMed1 = med1;
        final String finalMed2 = med2;
        compare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result;
                double cena1=Double.parseDouble(weight1.getText().toString())*map.get(finalMed1);
                double cena2=Double.parseDouble(weight2.getText().toString())*map.get(finalMed2);
                //if ( Double.parseDouble(weight1.getText().toString())*map.get(finalMed1) > Double.parseDouble(weight2.getText().toString())*map.get(finalMed2) ){
                if(cena1>cena2){
                    result="Cenejši je: "+finalMed2+" : "+String.format("%.4f", cena2)+" €";
                }else if(cena1==cena2)
                    result="Ceni sta enaki : "+String.format("%.4f", cena1)+" €";
                else
                    result="Cenejši je: "+finalMed1+" : "+String.format("%.4f", cena1)+" €";

                Intent returnIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("result",result);
                returnIntent.putExtras(bundle);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
