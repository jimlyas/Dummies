package com.epizy.someone.jimly_1202150091_modul3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class listjenisaer extends AppCompatActivity {
    RecyclerView rv; adapteraer adapter; List<aer> aernya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listjenisaer);
        setTitle("List Air");

        rv = findViewById(R.id.list_aer);
        rv.setHasFixedSize(true);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            rv.setLayoutManager(new GridLayoutManager(listjenisaer.this, 1));
        }else{
            rv.setLayoutManager(new GridLayoutManager(listjenisaer.this, 2));
        }
        aernya = new ArrayList<>();
        initdata();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            rv.setLayoutManager(new GridLayoutManager(listjenisaer.this, 1));
        }else{
            rv.setLayoutManager(new GridLayoutManager(listjenisaer.this, 2));
        }
    }

    public void initdata(){
        aernya.add(new aer("Ades", "Nama aernya ades", R.drawable.ades));
        aernya.add(new aer("Amidis", "Nama aernya amidis", R.drawable.amidis));
        aernya.add(new aer("Aqua", "Nama aernya aqua", R.drawable.aqua));
        aernya.add(new aer("Cleo", "Nama aernya Cleo", R.drawable.cleo));
        aernya.add(new aer("Club", "Nama aernya Club", R.drawable.club));
        aernya.add(new aer("Equil", "Nama aernya Equil", R.drawable.equil));
        aernya.add(new aer("Evian", "Nama aernya Evian", R.drawable.evian));
        aernya.add(new aer("Le Minarale", "Nama aernya Le Minerale", R.drawable.leminerale));
        aernya.add(new aer("Nestle", "Nama aernya Nestle", R.drawable.nestle));
        aernya.add(new aer("Pristine", "Nama aernya Pristine", R.drawable.pristine));
        aernya.add(new aer("Vit", "Nama aernya Vit", R.drawable.vit));
        adapter = new adapteraer(listjenisaer.this, aernya);
        rv.setAdapter(adapter);
    }

}
