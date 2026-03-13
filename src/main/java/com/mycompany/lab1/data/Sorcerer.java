/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 *
 * @author temdo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Sorcerer {
    @XmlElement
    private String name;
    @XmlElement
    private String rank;
    
    public Sorcerer(){}
    
    

    public Sorcerer(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public void info(){
        System.out.println("----name: " + getName());
        System.out.println("----rank: " + getRank());
    }
}
