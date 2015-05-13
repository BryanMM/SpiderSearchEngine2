/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xmlreader.*;
import EstructurasDeDatos.*;

/**
 *
 * @author Isaac Núñez
 */
public class XMLConfig {
    private  ListaCircularDoble Configuracion;
    private NodeList Nodeconfig;
    
    /**
     *
     */
    public XMLConfig(){
        Configuracion = new ListaCircularDoble();
        
        
        
    }

    /**
     *
     * @return
     */
    public ListaCircularDoble getConfiguracion() {
        return Configuracion;
    }

    /**
     *
     * @param Configuracion
     */
    public void setConfiguracion(ListaCircularDoble Configuracion) {
        this.Configuracion = Configuracion;
    }
    
    /**
     *
     */
    public void ReadConfig(){
        try{
            File config = new File("XMLConfig.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc1 = db.parse(config);
            doc1.getDocumentElement().normalize();
            
            NodeList nodeconfig = doc1.getElementsByTagName("spider");
            System.out.println(nodeconfig.getLength());
            
            for (int n = 0; n != nodeconfig.getLength(); n++){
                NodeList element = (NodeList) nodeconfig.item(n);
                for (int j = 0; j < element.getLength(); j++){
                    Node element1 = element.item(j);
                    if (element1.getNodeType() == Node.ELEMENT_NODE){
                        Node dato = element1.getFirstChild();
                        
                        if (dato != null && dato.getNodeType() == Node.TEXT_NODE){
                            
                            Configuracion.insertarFinal(element1.getFirstChild().toString().substring(8, element1.getFirstChild().toString().length()-1));
                            
                        }
                    }
                }
            }
            Configuracion.imprimir();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
}
