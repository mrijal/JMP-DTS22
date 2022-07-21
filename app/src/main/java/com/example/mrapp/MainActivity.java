package com.example.mrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etAngka;
    Button bProses;
    TextView tvHasil;
    Button bAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAbout = findViewById(R.id.b_about);
        etAngka = findViewById(R.id.editTextNumber);
        bProses = findViewById(R.id.b_proses);
        tvHasil = findViewById(R.id.tv_hasil);
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        AboutActivity.class);
                startActivity(intent);
            }
        });

        bProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ambil angka dari edit text
                int angka = Integer.parseInt(etAngka.getText()
                        .toString());

                String hasil;
                if(angka%2 == 0){
                    hasil = getString(R.string.teks_genap,angka);
                }else{
                    hasil = getString(R.string.teks_ganjil,angka);
                }
                tvHasil.setText(hasil);
            }
        });

    }
}