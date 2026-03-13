/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.readers;

import com.mycompany.lab1.data.Curse;
import com.mycompany.lab1.data.Mission;
import com.mycompany.lab1.data.Sorcerer;
import com.mycompany.lab1.data.Technique;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author temdo
 */
public class TextReader extends FileReader{
    private final String[] mission_attributes = {"missionId", "date", "location", "outcome", "damageCost"};
    private final String[] curse_attributes = {"curse.name", "curse.threatLevel"};
    private final String[] sorcerers_attributes = {"sorcerer", "name", "rank"};
    private final String[] techniques_attributes = {"technique", "name", "type", "owner", "damage"}; 
    @Override
    public Mission getMissionInfo(String path){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            
            String line = "";
           
            int sorcerer_count = 0;
            int techniques_count = 0;
            
            while ((line = br.readLine()) != null) {
               if (line.isBlank() || line.isEmpty()) continue;
               if (line.contains(sorcerers_attributes[0])) sorcerer_count++;
               if (line.contains(techniques_attributes[0])) techniques_count++;
            }
            br.close();
            
            Mission mission = new Mission();
            Curse curse = new Curse();
            ArrayList<Sorcerer> sorcerers = new ArrayList();
            ArrayList<Technique> techniques = new ArrayList();
            
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            
            for (int i = 0; i < sorcerer_count/2; i++) {
                sorcerers.add(new Sorcerer());
            }
            for (int i = 0; i < techniques_count/4; i++) {
                techniques.add(new Technique());
            }
            
            
            
            while ((line = br.readLine()) != null) {
                if (line.isBlank() || line.isEmpty()) continue;
                String[] arr = line.split(":");
                
                //mission attributes checkout
                if (arr[0].contains(mission_attributes[0])){
                    mission.setMissionId(arr[1]);
                }
                else if (arr[0].contains(mission_attributes[1])){
                    mission.setDate(arr[1]);
                }
                else if (arr[0].contains(mission_attributes[2])){
                    mission.setLocation(arr[1]);
                }
                else if (arr[0].contains(mission_attributes[3])){
                    mission.setOutcome(arr[1]);
                }
                else if (arr[0].contains(mission_attributes[4])){
                    mission.setDamageCost(getNumberFromLine(arr[1]));
                }
                
                //curse attributes checkout
                else if (arr[0].contains(curse_attributes[0])){
                    curse.setName(arr[1]);
                }
                else if (arr[0].contains(curse_attributes[1])){
                    curse.setThreatLevel(arr[1]);
                }
                
                //sorcerers attributes checkout
                else if (arr[0].contains(sorcerers_attributes[0]) && arr[0].contains(sorcerers_attributes[1])){
                    int index = getNumberFromLine(arr[0]);
                    sorcerers.get(index).setName(arr[1]);
                }
                else if (arr[0].contains(sorcerers_attributes[0]) && arr[0].contains(sorcerers_attributes[2])){
                    int index = getNumberFromLine(arr[0]);
                    sorcerers.get(index).setRank(arr[1]);
                }
                
                //techniques attributes checkout
                else if (arr[0].contains(techniques_attributes[0]) && arr[0].contains(techniques_attributes[1])){
                    int index = getNumberFromLine(arr[0]);
                    techniques.get(index).setName(arr[1]);
                }
                else if (arr[0].contains(techniques_attributes[0]) && arr[0].contains(techniques_attributes[2])){
                    int index = getNumberFromLine(arr[0]);
                    techniques.get(index).setType(arr[1]);
                }
                else if (arr[0].contains(techniques_attributes[0]) && arr[0].contains(techniques_attributes[3])){
                    int index = getNumberFromLine(arr[0]);
                    techniques.get(index).setOwner(arr[1]);
                }
                else if (arr[0].contains(techniques_attributes[0]) && arr[0].contains(techniques_attributes[4])){
                    int index = getNumberFromLine(arr[0]);
                    techniques.get(index).setDamage(getNumberFromLine(arr[1]));
                }
                
                //extras
                else{
                    mission.addExtra(arr[0], arr[1]);
                }
            }
            br.close();
            mission.setCurse(curse);
            mission.setSorcerers(sorcerers);
            mission.setTechniques(techniques);
            
            return mission;
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer getNumberFromLine(String line) {
        if (line == null || line.isEmpty()) return null;
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char s = line.charAt(i);
            if (Character.isDigit(s)) {
                numberBuilder.append(s);
            }
        }
        if (numberBuilder.length() > 0) {
            return Integer.parseInt(numberBuilder.toString());
        }

        return null;
    }
    
    
}
