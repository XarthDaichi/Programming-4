/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.presentation.cartelera;
import com.cine.cine.logic.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramim
 */
public class Model {
    List<Pelicula> peliculas;
    List<String> dias;

    public Model() {
        peliculas=new ArrayList<Pelicula>();
        dias=new ArrayList<String>();
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }
    
    
}
