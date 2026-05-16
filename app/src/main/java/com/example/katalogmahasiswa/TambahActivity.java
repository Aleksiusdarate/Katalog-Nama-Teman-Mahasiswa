package com.example.katalogmahasiswa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {

    EditText etNama;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.etNama);
        btnSimpan = findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(v -> {

            String nama = etNama.getText().toString().trim();

            // VALIDASI INPUT
            if (nama.isEmpty()) {

                etNama.setError("Nama mahasiswa tidak boleh kosong");
                etNama.requestFocus();

            } else {

                Toast.makeText(
                        TambahActivity.this,
                        "Data berhasil disimpan",
                        Toast.LENGTH_SHORT
                ).show();

            }

        });

    }
}