/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Facade;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gabriel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ParserConfigurationException, SAXException {
        VentanaSpider _ventana=new VentanaSpider(new Facade());
        //InterfazGrafica _interfaz = new InterfazGrafica(new Facade());
        // TODO code application logic here
        _ventana.setVisible(true);
        /**_interfaz.HiperLink();
        _interfaz.setVisible(true);*/
        
    }
    
}
