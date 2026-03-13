/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.lab1.data.Mission;
import com.mycompany.lab1.readers.FileReader;
import com.mycompany.lab1.readers.ReaderFabric;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author temdo
 */
public class FileManager {
    private boolean isRunning;
    private Scanner sc = new Scanner(System.in);
    private ReaderFabric fabric = new ReaderFabric();

    public FileManager() {
        isRunning = true;
        run();
    }
    
    
    
    
    private void run(){
        while(isRunning){
            
            try{
                String input = sc.nextLine();
                if (input.equals("stop")) {
                    stop();
                    break;
                }
                String cleanInput = input.replaceAll("\"", "");
                
                
                String ext = FilenameUtils.getExtension(cleanInput);
                System.out.println(cleanInput);
                
                FileReader reader = null;

                switch(ext){
                    case "json":{
                       reader = fabric.createJsonReader();
                       break;
                    }

                    case "txt":{
                       reader = fabric.createTextReader();
                       break;
                    }

                    case "xml":{
                       reader = fabric.createXmlReader();
                       break;
                    }

                }

                Mission mission = reader.getMissionInfo(cleanInput);
                mission.info();
                save(mission, ext);
                
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Something went wrong. Try again");
                
            }
        }
    }
    
    public void stop(){
        isRunning = false;
    }
    public void save(Mission mission, String ext){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(mission.getMissionId() + "__" + ext + "__" + ".json"), mission);
            System.out.println("JSON файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


