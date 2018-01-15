package vaje.si.fri.emp.zdravila.Zdravilo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import vaje.si.fri.emp.zdravila.R;


/**
 * Created by Hisa on 09/01/2018.
 */

public class ZdravilaAddapter extends RecyclerView.Adapter<ZdravilaAddapter.ViewHolder> {

    public interface OnZdraviloClickListener {
        void onZdraviloClicked(Zdravilo zdravilo);
    }

    private ArrayList<Zdravilo> arradyZdravil;
    private Context context;
    private OnZdraviloClickListener listener;

    public ZdravilaAddapter(Context context){
        this.context = context;

        try{
            listener= (OnZdraviloClickListener) context;

        }catch (ClassCastException e){
            throw new ClassCastException("Activity does not implement OnZdraviloClickedListener.");
        }

    }

    public void setData(ArrayList<Zdravilo> arradyZdravil){
        this.arradyZdravil=arradyZdravil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new  ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zdravilo, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(getZdravilo(position).getName());
        holder.tvManu.setText(getZdravilo(position).getId_manu());

    }

    private Zdravilo getZdravilo(int pos){
        return arradyZdravil.get(pos);
    }

    @Override
    public int getItemCount() {
        return (arradyZdravil == null) ? 0:arradyZdravil.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.tVname)
        TextView tvName;
        @BindView(R.id.tVmanu)
        TextView tvManu;
        LinearLayout llpolje;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            tvName = (TextView) itemView.findViewById(R.id.tVname);
            tvManu = (TextView) itemView.findViewById(R.id.tVmanu);
            llpolje= (LinearLayout) itemView.findViewById(R.id.llLayout);
            llpolje.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onZdraviloClicked(getZdravilo(getAdapterPosition()));
        }
    }

}
