package com.example.practicno1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<User> Users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Users = new ArrayList<>();

        //Загружаем данные пользователей из бд
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        while(query.moveToNext()){
            String login = query.getString(0);
            String password = query.getString(1);
            Users.add(new User(login, password));
        }
        query.close();
        db.close();
    }

    public void LogInClick (View view) {
        Intent profile = new Intent(MainActivity.this, Profile.class);
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPassword);
        boolean found = false;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        for (User item: MainActivity.Users) {
            if (logT.getText().toString().equals(item.login))
            {
                found = true;

                if (item.getPassword().equals(passT.getText().toString()))
                {
                    User.LastUser = item.login;
                    logT.setText("");
                    passT.setText("");
                    startActivity(profile);
                    break;
                }
                else
                {
                    alert.setTitle("Wrong!");
                    alert.setMessage("Password is incorrect!");
                    alert.show();
                }

            }
        }
        if (!found)
        {
            alert.setTitle("Not found!");
            alert.setMessage("No users with that login is found");
            alert.show();
        }
    }

    public void SignUpClick (View view){
        Intent sign = new Intent(MainActivity.this, SingUp.class);
        startActivity(sign);
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPassword);
        logT.setText("");
        passT.setText("");
    }
}

