/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.countries.logic;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ESCINF
 */
public class Country implements Serializable{
    String name;
    String capital;
    long population;
    long area;
    List<Integer> latlng;
    String flag;

    
    public Country(String name, String capital, long population, long area, List<Integer> latlng, String flag) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.latlng = latlng;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public List<Integer> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Integer> latlng) {
        this.latlng = latlng;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


}
