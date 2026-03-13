/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.readers;

import com.mycompany.lab1.data.Mission;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author temdo
 */
public class XmlReader extends FileReader{
    
    @Override
    public Mission getMissionInfo(String path){
        Mission mission;
        try {
            JAXBContext context = JAXBContext.newInstance(Mission.class);
            Unmarshaller unmar = context.createUnmarshaller();
            mission = (Mission) unmar.unmarshal(new File(path));
            return mission;
        } catch (JAXBException ex) {
            System.getLogger(XmlReader.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
