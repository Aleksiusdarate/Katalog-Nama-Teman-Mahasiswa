package com.example.katalogmahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // HUBUNGKAN ID
        etCari = findViewById(R.id.etCari);
        btnTambah = findViewById(R.id.btnTambah);
        btnAZ = findViewById(R.id.btnAZ);
        btnZA = findViewById(R.id.btnZA);
        listMahasiswa = findViewById(R.id.listMahasiswa);

        // ARRAY DATA
        dataMahasiswa = new ArrayList<>();

        // DATA AWAL
        dataMahasiswa.add("Alex");
        dataMahasiswa.add("Budi");
        dataMahasiswa.add("Citra");
        dataMahasiswa.add("Dika");
        dataMahasiswa.add("Eko");

        // ADAPTER
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataMahasiswa
        );

        // TAMPILKAN KE LISTVIEW
        listMahasiswa.setAdapter(adapter);

        // INTENT KE HALAMAN TAMBAH
        btnTambah.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, TambahActivity.class);
            startActivity(intent);

        });

        // SEARCHING
        etCari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // SORTING A-Z
        btnAZ.setOnClickListener(v -> {

            Collections.sort(dataMahasiswa);
            adapter.notifyDataSetChanged();

        });

        // SORTING Z-A
        btnZA.setOnClickListener(v -> {

            Collections.sort(dataMahasiswa, Collections.reverseOrder());
            adapter.notifyDataSetChanged();

        });

    }
}