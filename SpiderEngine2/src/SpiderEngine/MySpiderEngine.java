/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;
import Arboles.BinaryT;
import Logica.Keyword;
import Logica.MyURL;
import EstructurasDeDatos.*;
import Logica.Facade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import xmlreader.XMLData;



/**
 *
 * @author Gabo
 */
public class MySpiderEngine {
    private ListaCircularDoble<Keyword> _listaKeywords;
    private ListaCircularDoble<MyURL> _listaURL;
    private ListaCircularDoble<MyURL> _urlRecuperadas;
    private BinaryT<Keyword> _binarioKeywords;
    private int Score =0;
    private  ListaCircularDoble<String> _topBusquedas = new ListaCircularDoble();
    private  ListaCircularDoble<String> _recientesBusquedas = new ListaCircularDoble();
    private Facade _manager;
    private XMLData leer;
   

    /**
     *
     * @param _pManager
     */
    public MySpiderEngine(Facade _pManager) throws ParserConfigurationException, SAXException, IOException{
        _listaKeywords=new ListaCircularDoble();
        _listaURL=new ListaCircularDoble();
        this._manager = _pManager;
        _urlRecuperadas=new ListaCircularDoble();
        XMLData leer= new XMLData();
        this._binarioKeywords=leer.LeerData();
        
       
    }

    /**
     *
     * @param pText
     */
    public void quitarCaracteres(String pText){
        while(!pText.isEmpty()){
                String[] split = pText.split("");
                System.out.println(split.toString());
        }
        }

    /**
     *
     * @param pUrl
     */
    public void asignarTrustWorthy(MyURL pUrl){
    }

    /**
     *
     * @param pKey
     */
    public ListaCircularDoble<String>  buscar(String pFrase){
        ListaCircularDoble<String> _listaResultados=new ListaCircularDoble();
        String[] _arreglo=pFrase.split(" ");
        
                for (int c = 0; c < _arreglo.length; c++){
                    
                    Keyword comparador=new Keyword(_arreglo[c]);
                   
                    if(_binarioKeywords.contains(comparador)!=null){
                        System.out.println(_binarioKeywords.contains(comparador).getData().getPalabra());
                       //_listaResultados.insertarFinal(_binarioKeywords.contains(comparador).getData().getDirectorios().);
                       // _binarioKeywords.delete(comparador);
                    }
                    
                }
            
        System.out.println("Cantidad Resultados "+_listaResultados.getCantidadElementos());
        _listaResultados.imprimir();
        return _listaResultados;
    }

    
    /**
     *
     * @return
     */
    public ListaCircularDoble<String> enviarResultados(){
        return _recientesBusquedas;
    }
    
    
}
