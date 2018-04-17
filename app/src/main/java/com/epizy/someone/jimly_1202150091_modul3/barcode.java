package com.epizy.someone.jimly_1202150091_modul3;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class barcode extends AppCompatActivity {
    MultiFormatWriter fw; EditText source; ImageView entry; TextView tulisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_barcode);
        fw = new MultiFormatWriter();
        source = findViewById(R.id.sourcebarcode);
        entry = findViewById(R.id.entrybarcode);
        tulisan  = findViewById(R.id.tulisandibarcode);
    }

    public void ngebuatbarcode(View view) {
        try {
            BitMatrix bit = fw.encode(source.getText().toString(), BarcodeFormat.QR_CODE, 225,225);
            Bitmap map = new BarcodeEncoder().createBitmap(bit);
            tulisan.setText(source.getText().toString());
            source.setText(null);
            entry.setImageBitmap(map);
        } catch (WriterException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
