package com.progra4.todoen1.logic;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diego
 */
public class Service {
    private static Service uniqueInstance;
    
    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    HashMap<String, User> users;
    
    HashMap<String, Question> questions;
    
    private Service() {
        users = new HashMap();
        questions = new HashMap();
        
        Question q;
       
        q = new Question("Not Object Oriented?", "Prog. Lang.", new HashMap<String, Boolean>() {{put("C++", false);put("C", true);put("Java", false);}});
        questions.put(q.getQuestion(), q);
        q = new Question("Is JS a Good Teacher", "Teach.", new HashMap<String, Boolean>() {{put("True", false);put("False", true);}});
        questions.put(q.getQuestion(), q);
        q = new Question("What is Java?", "Prog. Lang.", new HashMap<String, Boolean>() {{put("A type of java script", false);put("A programming Language", true);put("An IDE", false);put("A Coffee Place", false);}});
        questions.put(q.getQuestion(), q);
        
        User u;
        u = new User("xarthy", "111", new HashMap());
        u.getQuestions().put(q, true);
        users.put(u.getUsername(), u);
        u = new User("GTX", "222", new HashMap());
        users.put(u.getUsername(), u);
        u = new User("LewMontes", "333", new HashMap());
        users.put(u.getUsername(), u);
    }
    
    public User userLogin(String username, String pass) throws Exception {
        User user = users.get(username);
        if (user != null) {
            if (user.getPassword().equals(pass)) {
                return user;
            } else throw new Exception("Passwords don't match");
        } else throw new Exception("User does not exist");
    }
    
    public List<Question> find(User u, String top) {
        User user = users.get(u.getUsername());
        if (user != null) {
            return questions.values().stream().filter(q-> q.getTopic().contains(top) && user.getQuestions().get(q) == null).collect(Collectors.toList());
        }
        return questions.values().stream().filter(q -> q.getTopic().contains(top)).collect(Collectors.toList());
    }
    
    public Question read(String question) throws Exception {
        Question question_object = questions.get(question);
        if (question_object != null) {
            return question_object;
        } else throw new Exception("Could not find the question");
    }
    
    public Boolean solve(String username, String question, String option) {
        Question quest = questions.get(question);
        if (quest != null) {
            Boolean response = quest.getResponses().get(option);
            if (response != null) {
                User user = users.get(username);
                user.getQuestions().put(quest, true);
                return response;
            }
        }
        return false;
    }
}
