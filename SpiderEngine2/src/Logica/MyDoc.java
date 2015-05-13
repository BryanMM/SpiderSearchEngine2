/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arboles.Tree_AVL;
import EstructurasDeDatos.*;
import java.io.File;

/**
 *
 * @author Gabriel
 */
public class MyDoc implements Comparable {
    private Tree_AVL<Keyword> _avlKeywords = new Tree_AVL();
    private int _cantidadPalabras;
    
    
    
    private String _direccion;
  /**
     *Constructor por defecto
     */
    public void MyDoc(){
    }
    
    /**
     * Metodo que devuelve el arbol
     * @return Tree_AVL
     */
    public Tree_AVL<Keyword>  getArbolKeywords() {
        return _avlKeywords;
    }
    

    /**
     * Metodo que define un arbol como Tree_AVL
     * @param _listaKeywords
     */
    public void setArbolKeywords(Tree_AVL _listaKeywords) {
        this._avlKeywords = _listaKeywords;
    }

    /**
     * Devuelve la cantidad de palabras
     * @return int
     */
    public int getCantidadPalabras() {
        return _cantidadPalabras;
    }

    /**
     * Metodo que define un entero con cantidad de palabras
     * @param _cantidadPalabras
     */
    public void setCantidadPalabras(int _cantidadPalabras) {
        this._cantidadPalabras = _cantidadPalabras;
    }

    /**
     * Metodo que devuelve el directorio del documento
     * @return String 
     */
    public String getDireccion() {
        return _direccion;
    }

    /**
     * Metodo que define la direccion de un documento
     * @param _direccion
     */
    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }
    
   
 

    

 
    @Override
    public int compareTo(Object o) {
        MyDoc _doc=  (MyDoc)o;
        if (this._cantidadPalabras<_doc.getCantidadPalabras())
            return -1;
        else if (this._cantidadPalabras<_doc.getCantidadPalabras())
            return 1;
        else return 0;
    }

  
        
    
    
}
