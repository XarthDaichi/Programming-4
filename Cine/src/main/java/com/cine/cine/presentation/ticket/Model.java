/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.presentation.ticket;
import com.cine.cine.logic.*;
import com.cine.cine.presentation.cartelera.*;

/**
 *
 * @author ramim
 */
public class Model {
    Ticket ticket;

    public Model() {
        this.ticket = new Ticket(new Pelicula("", "", "", 0.0, "", "", 0.0, 0.0, ""), 0, 0, "", "", 0, "");
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
}
