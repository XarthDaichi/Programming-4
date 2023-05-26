/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.logic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramim
 */
public class Pelicula {
    String nombre;
    String formato;
    String genero;
    Double puntuacion;
    String publicoAdmite;
    String sala;
    List<String> tandas;
    Double precioGeneral;
    Double precioAdultoMayor;
    String fecha;

    public Pelicula(String nombre, String formato, String genero, Double puntuacion, String publicoAdmite, String sala, Double precioGeneral, Double precioAdultoMayor, String fecha) {
        this.nombre = nombre;
        this.formato = formato;
        this.genero = genero;
        this.puntuacion = puntuacion;
        this.publicoAdmite = publicoAdmite;
        this.sala = sala;
        this.precioGeneral = precioGeneral;
        this.precioAdultoMayor = precioAdultoMayor;
        this.tandas=new ArrayList<String>();
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPublicoAdmite() {
        return publicoAdmite;
    }

    public void setPublicoAdmite(String publicoAdmite) {
        this.publicoAdmite = publicoAdmite;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public List<String> getTandas() {
        return tandas;
    }

    public void setTandas(List<String> tandas) {
        this.tandas = tandas;
    }

    public Double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(Double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public Double getPrecioAdultoMayor() {
        return precioAdultoMayor;
    }

    public void setPrecioAdultoMayor(Double precioAdultoMayor) {
        this.precioAdultoMayor = precioAdultoMayor;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}