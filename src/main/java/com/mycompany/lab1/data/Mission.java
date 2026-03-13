/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
@XmlRootElement(name = "mission")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mission {
    @XmlElement
    private String missionId;
    @XmlElement
    private String date;
    @XmlElement
    private String location;
    @XmlElement
    private String outcome;
    @XmlElement
    private Integer damageCost;
    @XmlElement(name = "curse")
    private Curse curse;
    @XmlElementWrapper(name = "sorcerers")
    @XmlElement(name = "sorcerer")
    private List<Sorcerer> sorcerers;
    @XmlElementWrapper(name = "techniques")
    @XmlElement(name = "technique")
    private List<Technique> techniques;
    
    private Map<String, Object> extras = new HashMap<>();
    
    public Mission(){}

    public Mission(String missionId, String date, String location, String outcome, Integer damageCost, Curse curse, List<Sorcerer> sorcerers, List<Technique> techniques) {
        this.missionId = missionId;
        this.date = date;
        this.location = location;
        this.outcome = outcome;
        this.damageCost = damageCost;
        this.curse = curse;
        this.sorcerers = sorcerers;
        this.techniques = techniques;
    }
    
    

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Integer getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(Integer damageCost) {
        this.damageCost = damageCost;
    }

    public Curse getCurse() {
        return curse;
    }

    public void setCurse(Curse curse) {
        this.curse = curse;
    }

    public List<Sorcerer> getSorcerers() {
        return sorcerers;
    }

    public void setSorcerers(List<Sorcerer> sorcerers) {
        this.sorcerers = sorcerers;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }
    
    public Map<String, Object> getExtras() {
        return extras;
    }

    @JsonAnySetter
    public void addExtra(String key, Object value) {
        extras.put(key, value);
    }
    
    public void info(){
        System.out.println("missionId: " + getMissionId());
        System.out.println("date: " + getDate());
        System.out.println("location: " + getLocation());
        System.out.println("outcome: " + getOutcome());
        System.out.println("damageCost: " + getDamageCost());
        System.out.println("curse: ");
        getCurse().info();
        System.out.println("sorcerers: ");
        
        List<Sorcerer> src = getSorcerers();
        for (int i = 0; i < src.size(); i++) {
            System.out.println("sorcerer " + (i+1));
            src.get(i).info();
        }
        
        List<Technique> tchs = getTechniques();
        for (int i = 0; i < tchs.size(); i++) {
            System.out.println("technique " + (i+1));
            tchs.get(i).info();
        }
        
        Map<String, Object> ex = getExtras();
        for (Map.Entry<String, Object> entry : ex.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
     
    }
}
