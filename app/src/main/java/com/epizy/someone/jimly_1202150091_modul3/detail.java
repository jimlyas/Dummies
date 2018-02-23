package com.epizy.someone.jimly_1202150091_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {
    ImageView baack, galonnya;
    TextView nama, detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar tool = findViewById(R.id.toolbarnya_detail);
        setSupportActionBar(tool);

        baack = findViewById(R.id.gambarnya_aer);
        baack.setImageDrawable(getResources().getDrawable(Integer.valueOf(getIntent().getStringExtra("background"))));
        baack.setScaleType(ImageView.ScaleType.FIT_XY);

        nama = findViewById(R.id.detail_nama_aer);
        nama.setText(getIntent().getStringExtra("nama"));

        detail = findViewById(R.id.detailnya_aer);
        detail.setText(getIntent().getStringExtra("detail"));

        galonnya = findViewById(R.id.galonyangdiisi);
        galonnya.setImageLevel(0);

    }

    public void tambahin(View view) {
        if(galonnya.getDrawable().getLevel()+1<=4){
            galonnya.setImageLevel(galonnya.getDrawable().getLevel()+1);
        }else{
            galonnya.setImageLevel(4);
            Toast.makeText(this, "Galonnya udah penuh!", Toast.LENGTH_SHORT).show();
        }
    }

    public void kurangin(View view) {
        if(galonnya.getDrawable().getLevel()-1>=0){
            galonnya.setImageLevel(galonnya.getDrawable().getLevel()-1);
        }else{
            galonnya.setImageLevel(0);
            Toast.makeText(this, "Galonnya mau kosong!", Toast.LENGTH_SHORT).show();
        }
    }
}
