package com.example.practicno1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    public static String LastUser;
    String login, password;
    public User(String log, String pass)
    {
        this.login = log;
        this.password = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<String> GetLogins()
    {
        ArrayList<String> arr = new ArrayList<>();
        for (User item:
             MainActivity.Users) {
            arr.add(item.login);
        }
        return arr;
    }
}
