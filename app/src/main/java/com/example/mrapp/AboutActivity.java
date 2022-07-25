package com.example.mrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    Button kembali;
    Button hitung;
    TextView hasilKel;
    TextView hasilLuas;
    EditText jariJari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        kembali = findViewById(R.id.kembali);
        hitung = findViewById(R.id.buttonHasil);
        jariJari = findViewById(R.id.jariJari);
        hasilKel = findViewById(R.id.hasilKel);
        hasilLuas = findViewById(R.id.hasilLuas);

        hitung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String angkaMentah = jariJari.getText().toString();
                int angka = Integer.parseInt(angkaMentah);

                String keliling = null;
                String Luas = null;
                if (angkaMentah.matches("")){
                    Toast.makeText(AboutActivity.this, "Masukkan Jari jari", Toast.LENGTH_SHORT).show();
                } else {
                    keliling = Double.toString(2*3.14*angka);
                    Luas = Double.toString(3.14*angka*angka);
                }
                hasilKel.setText(keliling);
                hasilLuas.setText(Luas);
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

    }
}