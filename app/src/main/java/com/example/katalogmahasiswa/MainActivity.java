package com.example.katalogmahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText etCari;
    Button btnTambah, btnAZ, btnZA;
    ListView listMahasiswa;

    ArrayList<String> dataMahasiswa;
    ArrayAdapter<String> adapter;

    String TAG = "42430009";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        try {

            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            // HUBUNGKAN ID
            etCari = findViewById(R.id.etCari);
            btnTambah = findViewById(R.id.btnTambah);
            btnAZ = findViewById(R.id.btnAZ);
            btnZA = findViewById(R.id.btnZA);
            listMahasiswa = findViewById(R.id.listMahasiswa);

            Log.d(TAG, "Komponen berhasil dihubungkan");

            // ARRAY DATA
            dataMahasiswa = new ArrayList<>();

            // DATA AWAL
            dataMahasiswa.add("Alex");
            dataMahasiswa.add("Budi");
            dataMahasiswa.add("Citra");
            dataMahasiswa.add("Dika");
            dataMahasiswa.add("Eko");

            Log.d(TAG, "Data mahasiswa berhasil ditambahkan");

            // ADAPTER
            adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    dataMahasiswa
            );

            // TAMPILKAN KE LISTVIEW
            listMahasiswa.setAdapter(adapter);

            Log.d(TAG, "ListView berhasil ditampilkan");

            // INTENT KE HALAMAN TAMBAH
            btnTambah.setOnClickListener(v -> {

                try {

                    Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                    startActivity(intent);

                    Log.d(TAG, "Berpindah ke TambahActivity");

                } catch (Exception e) {

                    Log.e(TAG, "Error Intent: " + e.getMessage());
                    Toast.makeText(this, "Gagal pindah halaman", Toast.LENGTH_SHORT).show();

                }

            });

            // SEARCHING
            etCari.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    try {

                        adapter.getFilter().filter(s);
                        Log.d(TAG, "Searching: " + s);

                    } catch (Exception e) {

                        Log.e(TAG, "Error Searching: " + e.getMessage());

                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            // SORTING A-Z
            btnAZ.setOnClickListener(v -> {

                try {

                    Collections.sort(dataMahasiswa);
                    adapter.notifyDataSetChanged();

                    Log.d(TAG, "Sorting A-Z berhasil");

                } catch (Exception e) {

                    Log.e(TAG, "Error Sorting A-Z: " + e.getMessage());

                }

            });

            // SORTING Z-A
            btnZA.setOnClickListener(v -> {

                try {

                    Collections.sort(dataMahasiswa, Collections.reverseOrder());
                    adapter.notifyDataSetChanged();

                    Log.d(TAG, "Sorting Z-A berhasil");

                } catch (Exception e) {

                    Log.e(TAG, "Error Sorting Z-A: " + e.getMessage());

                }

            });

        } catch (Exception e) {

            Log.e(TAG, "Error Utama: " + e.getMessage());

            Toast.makeText(this,
                    "Terjadi kesalahan pada aplikasi",
                    Toast.LENGTH_LONG).show();

        }

    }
}