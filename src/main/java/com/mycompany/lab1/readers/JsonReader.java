/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.lab1.data.Mission;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author temdo
 */
public class JsonReader extends FileReader{
    
    @Override
    public Mission getMissionInfo(String path){
        ObjectMapper mapper = new ObjectMapper();
        Mission mission;
        try {
            // Read JSON from file and convert to a Java object
            mission = mapper.readValue(new File(path), Mission.class);
            return mission;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
