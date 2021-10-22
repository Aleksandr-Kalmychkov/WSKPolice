package com.example.practicno1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

public class SingUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void SignUpClick (View view){
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPassword);
        String Log = logT.getText().toString();
        String Pass = passT.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        if (Log.equals("") || Pass.equals(""))
        {
            alert.setTitle("Not filled!");
            alert.setMessage("You must to fill all of fields");
            alert.show();
            return;
        }

        boolean found = false;

        for (User item: MainActivity.Users) {
            if (Log.equals(item.login))
            {
                found = true;
                alert.setTitle("Already exist");
                alert.setMessage("User exist");
                alert.show();
            }
        }
        if (!found)
        {
            SaveUser(Log, Pass);
            alert.setMessage("Successfully signed up");
            alert.setTitle("OK");
            alert.setPositiveButton("Log in", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    SingUp.this.finish();
                }
            });
            alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    SingUp.this.finish();
                }
            });
            alert.show();
        }
    }


    public void SaveUser(String login, String password)
    {
        ContentValues cv = new ContentValues();
        cv.put("login", login);
        cv.put("password", password);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.insert("Users", null, cv);
        db.close();
        MainActivity.Users.add(new User(login, password));
    }
}