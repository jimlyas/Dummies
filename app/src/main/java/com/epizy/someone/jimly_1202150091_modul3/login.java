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
        userinput = findViewById(R.id.input_user);
        passinput = findViewById(R.id.input_pass);
    }

    public void loggin(View view) {
        if(userinput.getText().toString().equals("EAD")&&passinput.getText().toString().equals("MOBILE")){
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(login.this, listjenisaer.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            finish();
        }else{
            Toast.makeText(this, "username or password is incorrect!", Toast.LENGTH_SHORT).show();
            userinput.setText(null); passinput.setText(null);
        }
    }
}
