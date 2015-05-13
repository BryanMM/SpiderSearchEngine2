/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;

import Logica.Facade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gabo
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try {
            // TODO code application logic here
            MySpiderEngine _prue=new MySpiderEngine(new Facade());
            _prue.buscar("clases objetos");
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
