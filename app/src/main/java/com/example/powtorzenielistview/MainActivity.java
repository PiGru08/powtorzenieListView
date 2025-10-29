package com.example.powtorzenielistview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListView listView2;
    EditText editTextDodajSwieto;
    Button buttondodaj;
    ArrayList<String> wszystkieSwieta = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewSwieta);
        listView2 = findViewById(R.id.listViewSwieta2);
        editTextDodajSwieto = findViewById(R.id.editTextTextDodajSwieto);
        buttondodaj = findViewById(R.id.buttonDodaj);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, listView.getItemAtPosition(i).toString() ,Toast.LENGTH_SHORT).show();
            }
        });
        wszystkieSwieta.add("11 Listopada - Święto nepodległości");
        wszystkieSwieta.add("2 listopada Zaduszki");
        wszystkieSwieta.add("6 grudnia - Mikołaj");
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, wszystkieSwieta);
        listView2.setAdapter(arrayAdapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                wszystkieSwieta.remove(i);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                return false;
            }
        });
        buttondodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String swieto = editTextDodajSwieto.getText().toString();
            wszystkieSwieta.add(swieto);
            editTextDodajSwieto.setText("");
            arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}