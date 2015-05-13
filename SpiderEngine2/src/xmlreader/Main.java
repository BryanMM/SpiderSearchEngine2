/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

import Logica.*;
import EstructurasDeDatos.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Isaac Núñez
 */
public class Main {

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException{
        //XMLData _nuevo= new XMLData();
        XMLData _nuevo=new XMLData();
        _nuevo.LeerData().inOrder();
        
        
      
        
    }
}
