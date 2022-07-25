package com.example.mrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etAngka;
    EditText etAngka1;
    Button bProses;
    TextView tvHasil;
    Button bAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAbout = findViewById(R.id.b_about);
        etAngka = findViewById(R.id.editTextNumber);
        etAngka1 = findViewById(R.id.editTextNumber2);
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
            @SuppressLint({"StringFormatMatches"})
            @Override
            public void onClick(View view) {
                //ambil angka dari edit text

                String angkaMentah = etAngka.getText()
                        .toString();
                String angka2Mentah = etAngka1.getText()
                        .toString();

                String hasil;
                if (angkaMentah.matches("")||angka2Mentah.matches("")){
                    tvHasil.setText(R.string.lengkapi);
                }else {
                    Integer angka = Integer.parseInt(etAngka.getText()
                            .toString());
                    Integer angka2 = Integer.parseInt(etAngka1.getText()
                            .toString());
                    if (angka > angka2) {
                        hasil = getString(R.string.lebih_besar, angka, angka2);
                    } else if (angka < angka2) {
                        hasil = getString(R.string.lebih_kecil, angka, angka2);
                    } else {
                        hasil = getString(R.string.sama_besar);
                    }
                    tvHasil.setText(hasil);
                }
            }
        });

    }
}