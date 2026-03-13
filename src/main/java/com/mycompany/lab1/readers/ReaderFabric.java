/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.readers;


/**
 *
 * @author temdo
 */
public class ReaderFabric {
    public FileReader createJsonReader(){
        return new JsonReader();
    }
    
    public FileReader createTextReader(){
        return new TextReader();
    }
    
    public FileReader createXmlReader(){
        return new XmlReader();
    }
}
