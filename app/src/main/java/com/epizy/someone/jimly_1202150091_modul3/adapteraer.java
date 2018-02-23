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

    //Constructor
    public adapteraer(Context con, List<aer> listaernya) {
        this.con = con;
        this.listaernya = listaernya;
    }

    //Method ketika holder dibuat
    @Override
    public aerholder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Mendapatkan layout untuk recyclerview
        View v = LayoutInflater.from(con).inflate(R.layout.layoutaernya, parent, false);
        aerholder x = new aerholder(v);
        return x;
    }


    //Method untuk memberikan nilai pada holder berdasarkan class aer
    @Override
    public void onBindViewHolder(aerholder holder, int position) {
        aer aernya = listaernya.get(position);
        holder.nama.setText(aernya.getNama().toString());
        holder.detail.setText(aernya.getDetail().toString());
        holder.rl.setBackground(holder.rl.getResources().getDrawable(aernya.getBaack()));
        holder.nama.setTag(aernya.getBaack());
    }

    //Menentukan ukuran list
    @Override
    public int getItemCount() {
        return listaernya.size();
    }


    //Sub class sebagai holder
    class aerholder extends RecyclerView.ViewHolder{
        RelativeLayout rl; TextView nama; TextView detail;
        public aerholder(View itemView) {
            super(itemView);

            //Menentukan object berdasarkan id-nya
            rl = itemView.findViewById(R.id.root_aer);
            nama = itemView.findViewById(R.id.nama_aer);
            detail = itemView.findViewById(R.id.detail_aer);

            //Method ketika cardview diklik
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Mendefinisikan intent baru
                    Intent pindahin = new Intent(con, detail.class);
                    //Menambahkan string extra untuk activity selanjutnya
                    pindahin.putExtra("nama", nama.getText());
                    pindahin.putExtra("detail", detail.getText());
                    pindahin.putExtra("background", nama.getTag().toString());
                    //Memulai activity baru
                    con.startActivity(pindahin);
                }
            });
        }
    }
}
