/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.logic;
import com.cine.cine.logic.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Cine
 */
public class Service{
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }

    List<Pelicula> peliculas;
    List<Ticket> tickets;
    
   private Service(){
        peliculas = new ArrayList<Pelicula>();
        tickets = new ArrayList<Ticket>();
        
        peliculas.add(new Pelicula("THE BATMAN", "2D DOB", "Acción", 2.55, "12", "1", 3000.0, 2500.0,this.obtenerFechaActual())); 
        peliculas.add(new Pelicula("MORBIUS", "2D DOB", "Acción", 1.45, "TP", "2", 3000.0, 2500.0,this.obtenerFechaActual())); 
        peliculas.add(new Pelicula("JUJUTSU KAISEN 0", "2D SUB", "Animadas", 1.45, "12", "3", 3000.0, 2500.0,this.obtenerFechaActual())); 
        peliculas.get(0).getTandas().add("02:30");
        peliculas.get(0).getTandas().add("06:00");
        peliculas.get(1).getTandas().add("12:20");
        peliculas.get(1).getTandas().add("02:35");
        peliculas.get(1).getTandas().add("04:45");
        peliculas.get(2).getTandas().add("12:20");
        peliculas.get(2).getTandas().add("02:30");
        peliculas.get(2).getTandas().add("04:40");
        peliculas.get(2).getTandas().add("06:55");
   }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
   
    public String agregarTiquete(Ticket ticket){
        this.tickets.add(ticket);
        Random random = new Random();
        String numeroAleatorio = "";
        for (int i = 0; i < 12; i++) {
            int digito = random.nextInt(10);
            numeroAleatorio += Integer.toString(digito);
        }
        return numeroAleatorio;
    }
   
    public String obtenerFechaActual() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE dd MMM", new Locale("en"));
        return fecha.format(formato).toUpperCase();
    }
    
    public String obtenerFechaFutura(int dias) {
        LocalDate fecha = LocalDate.now().plusDays(dias);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE dd MMM", new Locale("en"));
        return fecha.format(formato).toUpperCase();
    }
    
    public Ticket consultarTiquete(String codigo) {
        return this.tickets.stream().filter(ticket -> ticket.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
        
    public Pelicula getPelicula(String nombre) {
        return this.peliculas.stream().filter(pelicula -> pelicula.getNombre().equals(nombre)).findFirst().orElse(null);
    }
}
