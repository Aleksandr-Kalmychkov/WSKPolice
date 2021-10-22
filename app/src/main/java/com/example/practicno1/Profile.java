package com.example.practicno1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void ClickBack (View view)
    {
        Profile.this.finish();
    }

    public void AboutClick(View view)
    {
        Intent about = new Intent(Profile.this, About.class);
        startActivity(about);
    }

    public void DepartmentsClick(View view)
    {
        Intent intent = new Intent(Profile.this, Departments.class);
        startActivity(intent);
    }

    public void WantedClick(View view)
    {
        Intent intent = new Intent(Profile.this, Wanted.class);
        startActivity(intent);
    }

}