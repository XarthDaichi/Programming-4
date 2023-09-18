/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra4.todoen1.logic;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class User implements Serializable{
    private String username;
    private String password;
    private HashMap<Question, Boolean> questions;

    public User() {
        this.username = "";
        this.password = "";
        this.questions = new HashMap<>();
    }
    
    public User(String username, String password, HashMap<Question, Boolean> questions) {
        this.username = username;
        this.password = password;
        this.questions = questions;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Question, Boolean> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<Question, Boolean> questions) {
        this.questions = questions;
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }
}
