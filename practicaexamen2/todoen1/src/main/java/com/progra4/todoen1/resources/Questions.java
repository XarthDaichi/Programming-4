/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra4.todoen1.resources;

import com.progra4.todoen1.logic.Question;
import com.progra4.todoen1.logic.Service;
import com.progra4.todoen1.logic.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author diego
 */
@Path("/questions")
@PermitAll
public class Questions {
    /**
     * 
     * @param username
     * @param topic
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Question> find (@DefaultValue("") @QueryParam("username") String username, @DefaultValue("") @QueryParam("topic") String topic) throws Exception {
        User u = new User();
        u.setUsername(username);
        return Service.instance().find(u, topic);
    }
    
    @GET
    @Path("/{question}")
    @Produces({MediaType.APPLICATION_JSON})
    public Question read(@PathParam("question") String question) {
        try {
            return Service.instance().read(question);
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }
    
//    /**
//     * 
//     * @param question
//     * @param option
//     * @return
//     * @throws java.lang.Exception
//     */
//    @GET
//    @Path("/{username}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Boolean solve(@PathParam("username") String username, @QueryParam("question") String question, @QueryParam("option") String option) {
//        return Service.instance().solve(username, question, option);
//    }
}
