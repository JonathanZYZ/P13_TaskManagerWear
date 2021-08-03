package com.myapplicationdev.android.ps_taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvReminders;
    Button btnAdd;
    ArrayAdapter<Task> aa;
    ArrayList<Task> al;
    DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvReminders = (ListView) findViewById(R.id.lvReminders);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        dbh = new DBHelper(MainActivity.this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        al = new ArrayList<Task>();
        if (!dbh.getTasks().isEmpty()) {
            al = dbh.getTasks();
        }

        aa = new ArrayAdapter<Task>(getApplicationContext(), android.R.layout.simple_list_item_1, al);
        aa.notifyDataSetChanged();
        lvReminders.setAdapter(aa);


    }
}