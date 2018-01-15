package vaje.si.fri.emp.zdravila;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vaje.si.fri.emp.zdravila.Zdravilo.ZdravilaAddapter;
import vaje.si.fri.emp.zdravila.Zdravilo.Zdravilo;
import vaje.si.fri.emp.zdravila.API.RestClient;

public class PregledZdravil extends AppCompatActivity implements ZdravilaAddapter.OnZdraviloClickListener{

    RecyclerView pogled;

    ZdravilaAddapter adapter;
    RestClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregled_zdravil);// main activit

        //ButterKnife.bind(this);
        pogled = (RecyclerView) findViewById(R.id.rVPogled);
        client = new RestClient(this, "" );
        setUpRecycler();
        getZdravila();

    }

    private void setUpRecycler(){
        pogled.setHasFixedSize(true);
        pogled.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ZdravilaAddapter(this);

        pogled.setAdapter(adapter);
    }

    private void getZdravila(){
        Call<ArrayList<Zdravilo>> call = client.getrClient().getZdracila();

        call.enqueue(new Callback<ArrayList<Zdravilo>>() {
            @Override
            public void onResponse(Call<ArrayList<Zdravilo>> call, Response<ArrayList<Zdravilo>> response) {
                if(response.body() != null){
                    adapter.setData(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Zdravilo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onZdraviloClicked(Zdravilo zdravilo) {
        ZdraviloDialogFragment dialog = new ZdraviloDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Name", zdravilo.getName());
        bundle.putString("Id_manu", zdravilo.getId_manu());
        bundle.putString("NameLat", zdravilo.getNameLat());
        bundle.putString("Inst", zdravilo.getInst());
        bundle.putString("Descr", zdravilo.getDescr());

        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(),"ZdraviloFull");
    }

    public static class ZdraviloDialogFragment extends DialogFragment{

        private String Name ="";
        private String Id_manu="";
        private String NameLat="";
        private String Inst="";
        private String Descr="";

        TextView name,id_manu,nameLat,inst,descr;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public void onStart() {
            super.onStart();
            Dialog dialog = getDialog();
            if(dialog != null && dialog.getWindow() != null) {
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.item_celo_zdravilo, container, false);
            Bundle bundel = getArguments();
            if(bundel != null){
                Name = bundel.getString("Name");
                Id_manu = bundel.getString("Id_manu");
                NameLat = bundel.getString("NameLat");
                Inst = bundel.getString("Inst");
                Descr = bundel.getString("Descr");

            }
            return view;
            //return super.onCreateView(inflater, container, savedInstanceState);
        }


        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            name= (TextView) view.findViewById(R.id.tVName1);
            id_manu= (TextView) view.findViewById(R.id.tVManu1);
            nameLat= (TextView) view.findViewById(R.id.tVNameLat);
            inst= (TextView) view.findViewById(R.id.tVInst);
            descr= (TextView) view.findViewById(R.id.tVDescr);

            name.setText(Name);
            id_manu.setText(Id_manu);
            nameLat.setText(NameLat);
            inst.setText(Inst);
            descr.setText(Descr);




        }
    }

}
