package com.epizy.someone.jimly_1202150091_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText userinput, passinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Menentukan objek berdasarkan id-nya
        userinput = findViewById(R.id.input_user);
        passinput = findViewById(R.id.input_pass);
    }

    public void loggin(View view) {
        //Memeriksa apakah username dan password yang diinputkan benar
        if(userinput.getText().toString().equals("EAD")&&passinput.getText().toString().equals("MOBILE")){
            //Menampilkan toast
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            //Memulai activity baru
            startActivity(new Intent(login.this, listjenisaer.class));
            //Menambahkan transisi antar activity
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            //Menutup activity saat ini
            finish();
        }else{
            //Menampilkan toast ketika username atau password salah
            Toast.makeText(this, "username or password is incorrect!", Toast.LENGTH_SHORT).show();
            //Menghapus text saat ini pada field username dan password
            userinput.setText(null); passinput.setText(null);
        }
    }
}
