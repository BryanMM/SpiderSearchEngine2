/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import EstructurasDeDatos.*;

/**
 *
 * @author Isaac Núñez
 */
public class XMLReader {
   
    private  NodeList nodels;
    private ListaCircularDoble<String> URL1;

    /**
     *
     */
    public XMLReader(){
       URL1 = new ListaCircularDoble(); 
       
    }

    /**
     *
     * @return
     */
    public ListaCircularDoble<String> getURL1() {
        return URL1;
    }

    /**
     *
     * @param URL1
     */
    public void setURL1(ListaCircularDoble<String> URL1) {
        this.URL1 = URL1;
    }
    
    /**
     *
     * @param pURL
     */
    public void Read(String pURL){
        try{
            File file = new File(pURL);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList Nodels = doc.getElementsByTagName("targets");
            
            for (int s = 0; s != Nodels.getLength(); s++){
                
                Node element = Nodels.item(s);
                if (element.getNodeType() == Node.ELEMENT_NODE){
                        Element frstElem = (Element) element;
                    NodeList frstElemLs = frstElem.getElementsByTagName("URL");
                    Element frstElem1 = (Element) frstElemLs.item(0);
                    NodeList frstEl = frstElem1.getChildNodes();
                   
                    URL1.insertarFinal(((Node) frstEl.item(0)).toString().substring(8, ((Node) frstEl.item(0)).toString().length()-1));
                } 
            }
            //System.out.println(URL);
            URL1.imprimir();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    
}
