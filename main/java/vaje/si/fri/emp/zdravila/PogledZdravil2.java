package vaje.si.fri.emp.zdravila;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PogledZdravil2 extends AppCompatActivity implements ListView.OnItemSelectedListener{
    //private Spinner spinner;
    private ListView listView;
    EditText eTImepolje;
    //private ImageView imageView;
    private RequestQueue requestQueue;
    //private Button button;
    private Response.Listener<JSONArray> jsonArrayListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            ArrayList<HashMap<String, String >> data = new ArrayList<>();
            if(response.length() > 0){

            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject object = response.getJSONObject(i);
                    String name = object.getString("Name");
                    String manu = object.getString("Id_manu");
                    String description = object.get("Descr").toString();
                    String inst = object.get("Inst").toString();
                    String nameLat = object.get("NameLat").toString();
                    /*JSONArray domains = object.getJSONArray("topLevelDomain");
                    if (domains.length() > 0)
                        manu =domains.getString(0);*/
                    HashMap<String, String> map = new HashMap<>();

                    map.put("Name", name);
                    map.put("Id_manu", manu );
                    map.put("Descr", description);
                    map.put("Inst", inst);
                    map.put("NameLat", nameLat);
                    //map.put("Id_manu", manu);
                    data.add(map);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            }

            SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                    data, R.layout.list_layout, new String[]{"Name" },
                    new int[]{R.id.textViewName, R.id.textViewInfo});
            listView.setAdapter(adapter);
        }
    };

   /* private Response.Listener<Bitmap> bitmapListener = new Response.Listener<Bitmap>() {
        @Override
        public void onResponse(Bitmap response) {
            double ratio = (double)response.getHeight() / (double)response.getWidth();
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int newWidth = metrics.heightPixels;
            int newHeight = (int)((double)newWidth * ratio);
            Bitmap scaled = Bitmap.createScaledBitmap(response, newWidth, newHeight, false);
            imageView.setImageBitmap(scaled);
        }
    };*/

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("REST error", error.getMessage());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogled_zdravil2);

        //spinner = (Spinner)findViewById(R.id.spinner);
        listView = (ListView)findViewById(R.id.listView);
        this.eTImepolje = (EditText) findViewById(R.id.eTIme);
        //eTImepolje.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
       // imageView = (ImageView)findViewById(R.id.imageView);
       // button = (Button) findViewById(R.id.button2);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        //spinner.setOnItemSelectedListener(this);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                setTitle(parent.getItemAtPosition(position).toString());
            }
        };
        listView.setOnItemClickListener(listener);
       /* String url = "http://www.freeworldmaps.net/world/america-centric/america-centered-world-map.jpg";
        ImageRequest request = new ImageRequest(url, bitmapListener, 0, 0,
                ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, errorListener);
        requestQueue.add(request);*/


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (view != null) {
            TextView textView = (TextView)view;
            String url = "http://zdravilnica.azurewebsites.net/IZdravila.svc/Zdravila/" + textView.getText();
            JsonArrayRequest request = new JsonArrayRequest(url, jsonArrayListener, errorListener);
            requestQueue.add(request);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        String url = "http://zdravilnica.azurewebsites.net/IZdravila.svc/Zdravila";
        JsonArrayRequest request = new JsonArrayRequest(url, jsonArrayListener, errorListener);
        requestQueue.add(request);
    }

    public void onClickPogled(View v){
//        TextView textView = (TextView)v;
        String url = "http://zdravilnica.azurewebsites.net/IZdravila.svc/Zdravila" + "/"+ eTImepolje.getText()  ;
        JsonArrayRequest request = new JsonArrayRequest(url, jsonArrayListener, errorListener);
        requestQueue.add(request);
    }
}
