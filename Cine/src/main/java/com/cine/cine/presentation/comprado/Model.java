/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.presentation.comprado;
import com.cine.cine.presentation.comprado.*;
import com.cine.cine.logic.*;
import com.cine.cine.presentation.cartelera.*;

/**
 *
 * @author ramim
 */
public class Model {
    Ticket ticket;
    Pelicula pelicula;

    public Model() {
        this.pelicula = new Pelicula("", "", "", 0.0, "", "", 0.0, 0.0, "");
        this.ticket = new Ticket(new Pelicula("", "", "", 0.0, "", "", 0.0, 0.0, ""), 0, 0, "", "", 0, "");
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    
}
