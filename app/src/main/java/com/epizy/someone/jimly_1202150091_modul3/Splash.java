package com.epizy.someone.jimly_1202150091_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash);

        //Menjalankan method setelah 1,5 detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Memulai activity baru
                startActivity(new Intent(Splash.this, rooting.class));
                //Memberikan transisi antar activity
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                //Menutup activity saat ini
                finish();
            }
        }, 500);
    }
}
