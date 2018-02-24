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
    TextView nama, detail, liternya;
    int literaer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Menentukan toolbar pada activity saat ini
        Toolbar tool = findViewById(R.id.toolbarnya_detail);
        setSupportActionBar(tool);

        //Mengatur gambar pada toolbar
        baack = findViewById(R.id.gambarnya_aer);
        baack.setImageDrawable(getResources().getDrawable(Integer.valueOf(getIntent().getStringExtra("background"))));
        baack.setScaleType(ImageView.ScaleType.FIT_XY);

        //Menentukan tulisan pada textview nama
        nama = findViewById(R.id.detail_nama_aer);
        nama.setText(getIntent().getStringExtra("nama"));

        //Menentukan tulisan pada textview detail
        detail = findViewById(R.id.detailnya_aer);
        detail.setText(getIntent().getStringExtra("detail"));

        //Menentukan gambar pada imageview galonnya
        galonnya = findViewById(R.id.galonyangdiisi);
        galonnya.setImageLevel(0);

        //Menentukan text pada liternya
        liternya = findViewById(R.id.liternya);
        literaer = 20;
        liternya.setText(literaer+" Liter");

    }

    //Method ketika tombol + ditekan
    public void tambahin(View view) {
        //Memeriksa apakah botol telah penuh
        if(galonnya.getDrawable().getLevel()+1<=4){
            //Menambahkan level gambar
            galonnya.setImageLevel(galonnya.getDrawable().getLevel()+1);
            literaer+=20;
            liternya.setText(literaer+" Liter");
        }else{
            //ketika botol telah penuh lakukan :
            galonnya.setImageLevel(4);
            Toast.makeText(this, "Galonnya udah penuh!", Toast.LENGTH_SHORT).show();
        }
    }

    //Method ketika tombol - ditekan
    public void kurangin(View view) {
        //Memeriksa apakah botol akan kosong
        if(galonnya.getDrawable().getLevel()-1>=0){
            //Mengurangi level gambar
            galonnya.setImageLevel(galonnya.getDrawable().getLevel()-1);
            literaer-=20;
            liternya.setText(literaer+" Liter");
        }else{
            //Ketika botol telah kosong lakukan :
            galonnya.setImageLevel(0);
            Toast.makeText(this, "Galonnya mau kosong!", Toast.LENGTH_SHORT).show();
        }
    }
}
