/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arboles.Heap;
import EstructurasDeDatos.*;
import java.io.File;

/**
 *
 * @author Bryan
 */
public class MyURL {
    private int _indice=0;
    private int _cantidadApariciones;
    private String _link;
   

    
    public int Thrustworthy=1000; 
    
    
    /**
     *COnstructor por defecto
     */
public MyURL(){
        
        
    
}
    /**
     *
     * @param pDireccion
     */
    public MyURL(String pDireccion){
        this._link=pDireccion;
        
    
}

    /**
     *
     * @param pDireccion
     * @param pIndice
     */
    public MyURL(String pDireccion, int pIndice){
        this._link=pDireccion;
        this._indice=pIndice;
        
        
    
}

    /**
     *
     * @return
     */
    public int getIndice() {
        return _indice;
    }

    /**
     *
     * @param _indice
     */
    public void setIndice(int _indice) {
        this._indice = _indice;
    }

    /**
     *
     * @return
     */
    public int getCantidadApariciones() {
        return _cantidadApariciones;
    }

    /**
     *
     * @param _cantidadApariciones
     */
    public void setCantidadApariciones(int _cantidadApariciones) {
        this._cantidadApariciones = _cantidadApariciones;
    }

    /**
     *
     * @return
     */
    public String getLink() {
        return _link;
    }

    /**
     *
     * @param _link
     */
    public void setLink(String _link) {
        this._link = _link;
    }

 

 
    public int getThrustworthy() {
        return Thrustworthy;
    }

    public void setThrustworthy(int Thrustworthy) {
        this.Thrustworthy = Thrustworthy;
    }
    
    
    
}
