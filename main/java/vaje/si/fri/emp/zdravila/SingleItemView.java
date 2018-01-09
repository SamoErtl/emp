package vaje.si.fri.emp.zdravila;

/**
 * Created by jjmse on 09/01/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    String name;
    String manu;
    String namelat;
    String inst;
    String descr;
    //ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        // Get the result of name
        name = i.getStringExtra("name");
        // Get the result of manufacturer
        manu = i.getStringExtra("manu");
        // Get the result of latin name
        namelat = i.getStringExtra("namelat");
        // Get the result of instruction
        inst = i.getStringExtra("inst");
        // Get the result of desctiption
        descr = i.getStringExtra("descr");

        // Locate the TextViews in singleitemview.xml
        TextView txtname = (TextView) findViewById(R.id.name);
        TextView txtmanu = (TextView) findViewById(R.id.manu);
        TextView txtnamelat = (TextView) findViewById(R.id.namelat);
        TextView txtinst = (TextView) findViewById(R.id.inst);
        TextView txtdescr = (TextView) findViewById(R.id.descr);

        // Locate the ImageView in singleitemview.xml
        //ImageView imgflag = (ImageView) findViewById(R.id.flag);

        // Set results to the TextViews
        txtname.setText(name);
        txtmanu.setText(manu);
        txtnamelat.setText(namelat);
        txtinst.setText(inst);
        txtdescr.setText(descr);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        //imageLoader.DisplayImage(flag, imgflag);
    }
}
