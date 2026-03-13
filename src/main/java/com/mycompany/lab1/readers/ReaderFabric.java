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
    public JsonReader createJsonReader(){
        return new JsonReader();
    }
    
    public TextReader createTextReader(){
        return new TextReader();
    }
    
    public XmlReader createXmlReader(){
        return new XmlReader();
    }
}
