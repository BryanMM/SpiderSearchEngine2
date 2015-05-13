/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

import Arboles.BinaryT;
import EstructurasDeDatos.ListaCircularDoble;
import Logica.Keyword;
import Logica.MyURL;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Isaac Núñez
 */
public class XMLData {
    private NodeList data;
    private String prueba;
    
  

   
    
    /**
     *
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public BinaryT<Keyword> LeerData() throws ParserConfigurationException, SAXException, IOException{
        BinaryT<Keyword> _nuevoArbol=new BinaryT() ;
        try{
            File file = new File("MyXMLURL.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            data = doc.getElementsByTagName("URL");
            //System.out.println(data.getLength());

            for(int a = 0; a < data.getLength(); a++){
                MyURL datos = new MyURL();
                NodeList PriEle = (NodeList) data.item(a);
                for(int b = 0; b < PriEle.getLength(); b++){
                    Node SecondEle = PriEle.item(b);
                    String direct;
                    if (SecondEle.getNodeType() == Node.ELEMENT_NODE){
                        Node TercerLevel = SecondEle.getFirstChild();
                        
                        if (TercerLevel.getNodeType() == Node.TEXT_NODE && SecondEle.getNodeName().equals("Directorio")){
                             prueba=TercerLevel.toString().substring(8, TercerLevel.toString().length()-1);
                        }
                       
                        if (TercerLevel.getNodeType() == Node.TEXT_NODE && SecondEle.getNodeName().equals("Keyword")){
                            Keyword _nuevo = new Keyword();
                            
                            _nuevo.setPalabra(TercerLevel.toString().substring(8, TercerLevel.toString().lastIndexOf(":")));
                            if(_nuevoArbol.contains(_nuevo)==null){
                                _nuevo.setDirectorio(prueba);
                                _nuevo.getDirectorios().insert(prueba);
                            
                            
                                _nuevoArbol.insert(_nuevo);
                                
                            }
                            else{
                                 _nuevoArbol.contains(_nuevo).getData().setCantidadRepeticiones(_nuevoArbol.contains(_nuevo).getData().getCantidadRepeticiones()+1);
                                 _nuevoArbol.contains(_nuevo).getData().getDirectorios().insert(prueba);
                                
                            }
                            
                                
                           
                                
                             }
                            //datos.getListaKeywords().insertarFinal(_nuevo);
                            
                       
                    }
                    
                }
            
                
            }return _nuevoArbol;
            
            
            
           
        }catch(ParserConfigurationException | SAXException | IOException | IllegalArgumentException e){
        }
        
        return _nuevoArbol;
    }
}