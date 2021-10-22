package com.example.practicno1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DepInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dep_info);
    }

    public void ShowClick (View view)
    {
        //TO DO
    }
    public void ClickBack (View view)
    {
        this.finish();
    }
}