/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Interfaz.VentanaSpider;
import Interfaz.InterfazGrafica;
import xmlReader.*;

import EstructurasDeDatos.*;
import SpiderEngine.*;

import SpiderEngine.*;
import Spiderbot.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 *
 * @author Gabo
 */
public class Facade {
   
    private  MySpiderBot _spiderBot;
    private InterfazGrafica _ventanaPrincipal;
    private VentanaSpider _spiderVentana;
    private MySpiderEngine _spiderEngine;
    

    /**
     *
     * @throws IOException
     * @throws java.lang.InterruptedException
     */
    public Facade() throws IOException, InterruptedException{
        
       
//       _spiderEngine.quitarCaracteres(_ventanaPrincipal.jTextField1.getText());
       
       
      
      // _ventanaPrincipal=new InterfazGrafica();
       
       
   }
    public void inicializarSpiderbot(){
          
          _spiderVentana=new VentanaSpider(this);
         _spiderVentana.setVisible(true);  
    }
    public void inicializarSpiderEngine(){
        try {
            _ventanaPrincipal=new InterfazGrafica(this);
            _ventanaPrincipal.setVisible(true); 
            _spiderEngine=new MySpiderEngine(this);
            
        } catch (IOException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public MySpiderBot getSpiderBot() {
        return _spiderBot;
    }

    public void setSpiderBot(MySpiderBot _spiderBot) {
        this._spiderBot = _spiderBot;
    }

    public MySpiderEngine getSpiderEngine() {
        return _spiderEngine;
    }

    public void setSpiderEngine(MySpiderEngine _spiderEngine) {
        this._spiderEngine = _spiderEngine;
    }
    
    
   

  
    
   
   
    
    
    
    
    
}
