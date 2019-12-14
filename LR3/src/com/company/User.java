package com.company;

public class User {
    String name;
    String login;
    String password;

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    boolean Enter (String login1, String password1){
        return (login == login1 && password == password1);
    }
}
