/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Arboles.RedBlackT;
import EstructurasDeDatos.*;
/**
 *
 * @author Gabo
 */
public class Keyword implements Comparable<Keyword> {
    
    
    private int _cantidadRepeticiones=0;
    private String _palabra;
    private String _directorio;

    private RedBlackT<String> _directorios=new RedBlackT() ;
    
    /**
     * Constructor de la clase
     * @param pWord
     */
    public Keyword(String pWord){
        this._palabra=pWord;
        
    }

    /**
     *Constructor de la clase
     */
    public Keyword(){
    }
   

    /**
     * Metodo que agrega un url a la lista 
     * @param pUrl
     */
 
    /**
     *
     * @return
     */
    public int getCantidadRepeticiones() {
        return _cantidadRepeticiones;
    }

    /**
     *
     * @param _cantidadRepeticiones
     */
    public void setCantidadRepeticiones(int _cantidadRepeticiones) {
        this._cantidadRepeticiones = _cantidadRepeticiones;
    }

    /**
     *
     * @return
     */
    public String getPalabra() {
        return _palabra;
    }

    /**
     *
     * @param _palabra
     */
    public void setPalabra(String _palabra) {
        this._palabra = _palabra;
    }

    public RedBlackT<String> getDirectorios() {
        return _directorios;
    }

    public void setDirectorios(RedBlackT<String> _directorios) {
        this._directorios = _directorios;
    }

    public String getDirectorio() {
        return _directorio;
    }

    public void setDirectorio(String _directorio) {
        this._directorio = _directorio;
    }
    

    
   

   

    @Override
    public int compareTo(Keyword o) {
        return o.getPalabra().compareTo(this._palabra);
    }

   
    
    
    
}
