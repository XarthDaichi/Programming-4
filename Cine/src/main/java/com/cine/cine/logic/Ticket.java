/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.cine.logic;

public class Ticket {
    Pelicula pelicula;
    int cantidadBoletosGenerales;
    int cantidadBoletosAdultos;
    String nombre;
    String cedula;
    int tarjeta;
    String codigo;

    public Ticket(Pelicula pelicula, int cantidadBoletosGenerales, int cantidadBoletosAdultos, String nombre, String cedula, int tarjeta, String codigo) {
        this.pelicula = pelicula;
        this.cantidadBoletosGenerales = cantidadBoletosGenerales;
        this.cantidadBoletosAdultos = cantidadBoletosAdultos;
        this.nombre = nombre;
        this.cedula = cedula;
        this.tarjeta = tarjeta;
        this.codigo = codigo;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getCantidadBoletosGenerales() {
        return cantidadBoletosGenerales;
    }

    public void setCantidadBoletosGenerales(int cantidadBoletosGenerales) {
        this.cantidadBoletosGenerales = cantidadBoletosGenerales;
    }

    public int getCantidadBoletosAdultos() {
        return cantidadBoletosAdultos;
    }

    public void setCantidadBoletosAdultos(int cantidadBoletosAdultos) {
        this.cantidadBoletosAdultos = cantidadBoletosAdultos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }    
}