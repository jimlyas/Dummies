package com.epizy.someone.jimly_1202150091_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class adapteraer extends RecyclerView.Adapter<adapteraer.aerholder>{

    private Context con;
    private List<aer> listaernya;

    public adapteraer(Context con, List<aer> listaernya) {
        this.con = con;
        this.listaernya = listaernya;
    }

    @Override
    public aerholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.layoutaernya, parent, false);
        aerholder x = new aerholder(v);
        return x;
    }

    @Override
    public void onBindViewHolder(aerholder holder, int position) {
        aer aernya = listaernya.get(position);
        holder.nama.setText(aernya.getNama().toString());
        holder.detail.setText(aernya.getDetail().toString());
        holder.rl.setBackground(holder.rl.getResources().getDrawable(aernya.getBaack()));
        holder.nama.setTag(aernya.getBaack());
    }

    @Override
    public int getItemCount() {
        return listaernya.size();
    }

    class aerholder extends RecyclerView.ViewHolder{
        RelativeLayout rl; TextView nama; TextView detail;
        public aerholder(View itemView) {
            super(itemView);
            rl = itemView.findViewById(R.id.root_aer);
            nama = itemView.findViewById(R.id.nama_aer);
            detail = itemView.findViewById(R.id.detail_aer);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pindahin = new Intent(con, detail.class);
                    pindahin.putExtra("nama", nama.getText());
                    pindahin.putExtra("detail", detail.getText());
                    pindahin.putExtra("background", nama.getTag().toString());
                    con.startActivity(pindahin);
                }
            });
        }
    }
}
