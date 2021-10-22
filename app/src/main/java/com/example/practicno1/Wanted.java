package com.example.practicno1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Wanted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanted);
        ListView listview = findViewById(R.id.WantedList);
        /*TO DO
        парсинг преступников и их отображение
        */
        ArrayAdapter<User> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, User.GetLogins()/*Времмено выводим пользователей*/);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent dep = new Intent(Wanted.this, WantedInfo.class);
                startActivity(dep);
            }
        });
    }

    public void ClickBack (View view)
    {
        this.finish();
    }
}