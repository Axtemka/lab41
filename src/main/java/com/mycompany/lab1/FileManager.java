/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

/**
 *
 * @author temdo
 */
public class FileManager {
    private boolean isRunning;

    public FileManager() {
        isRunning = true;
        run();
    }
    
    
    
    
    public void run(){
        while(isRunning){
            //do stuff
        }
        // end of working, saving files
    }
    
    public void stop(){
        isRunning = false;
    }
}


