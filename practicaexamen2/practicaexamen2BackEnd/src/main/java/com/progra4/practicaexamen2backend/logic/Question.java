/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra4.practicaexamen2backend.logic;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class Question implements Serializable {
    private String question;
    private String topic;
    private HashMap<String, Boolean> responses;

    public Question() {
        this.question = "";
        this.topic = "";
        this.responses = new HashMap<>();
    }
    
    public Question(String question, String topic, HashMap<String, Boolean> responses) {
        this.question = question;
        this.topic = topic;
        this.responses = responses;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public HashMap<String, Boolean> getResponses() {
        return responses;
    }

    public void setResponses(HashMap<String, Boolean> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", topic=" + topic + ", responses=" + responses + '}';
    }
}
