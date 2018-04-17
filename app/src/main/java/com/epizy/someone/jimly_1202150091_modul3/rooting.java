package com.epizy.someone.jimly_1202150091_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rooting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_rooting);
    }

    public void bukaprofil(View view) {
        startActivity(new Intent(rooting.this, profiledummy.class));
    }

    public void bukadrawer(View view) {
        startActivity(new Intent(rooting.this, pushdrawer.class));
    }

    public void bukabarcode(View view) {
        startActivity(new Intent(rooting.this, barcode.class));
    }
}
