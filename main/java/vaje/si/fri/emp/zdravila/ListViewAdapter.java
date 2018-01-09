package vaje.si.fri.emp.zdravila;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by jjmse on 09/01/2018.
 */

public class ListViewAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView name  ;
        TextView manu;
        TextView namelat;
        TextView inst;
        TextView descr;

        //ImageView flag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        //View singelItemView = inflater.inflate(R.layout.singleitemview, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        name = (TextView) itemView.findViewById(R.id.name);
        manu = (TextView) itemView.findViewById(R.id.manu);
        namelat = (TextView) itemView.findViewById(R.id.namelat);
        inst = (TextView) itemView.findViewById(R.id.inst);
        descr = (TextView) itemView.findViewById(R.id.descr);


        // Locate the ImageView in listview_item.xml
        //flag = (ImageView) itemView.findViewById(R.id.flag);

        // Capture position and set results to the TextViews
        name.setText(resultp.get(PogledZdravil3.NAME));
        manu.setText(resultp.get(PogledZdravil3.MANU));
        namelat.setText(resultp.get(PogledZdravil3.NAMELAT));
        inst.setText(resultp.get(PogledZdravil3.INST));
        descr.setText((resultp.get((PogledZdravil3.DESCR))));
        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        //imageLoader.DisplayImage(resultp.get(MainActivity.FLAG), flag);
        // Capture ListView item click
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                resultp = data.get(position);
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data name
                intent.putExtra("name", resultp.get(PogledZdravil3.NAME));
                // Pass all data manu
                intent.putExtra("manu", resultp.get(PogledZdravil3.MANU));
                // Pass all data namelat
                intent.putExtra("namelat",resultp.get(PogledZdravil3.NAMELAT));

                intent.putExtra("inst", resultp.get(PogledZdravil3.INST));

                intent.putExtra("descr", resultp.get(PogledZdravil3.DESCR));
                // Pass all data flag
                //intent.putExtra("flag", resultp.get(MainActivity.FLAG));
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}
