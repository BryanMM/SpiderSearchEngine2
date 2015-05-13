/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Arboles;
import EstructurasDeDatos.*;
import Logica.MyDoc;
/**
 *
 * @author Gabo
 * Heap que implementa comparable para ser utilizado con objetos MyDoc
 * @param <MyDoc>
 */
public class Heap<MyDoc extends Comparable<MyDoc>> {
    private ListaCircularDoble<MyDoc> _arreglo ;
    
    
    /**
     * Conctructor del Heap
     */
    public Heap(){
        _arreglo=new ListaCircularDoble();
        
    
        }
    /**
     * Metodo que cheque asi el heap esta vacio
     * @return true si esta vacio, false lo contrario
     */
    public boolean estaVacio(){
        return _arreglo.estaVacia();
        
    
}

    /**
     * Metodo que devuelve el arreglo sobre el cual trabaja el heap
     * @return ListaCircularDoble
     */
    public ListaCircularDoble<MyDoc> getArreglo() {
        return _arreglo;
    }

    /**
     * Metodo que define el arreglo sobre el cual trabajara el heap
     * @param _arreglo
     */
    public void setArreglo(ListaCircularDoble<MyDoc> _arreglo) {
        this._arreglo = _arreglo;
    }

   

   
    
    /**
     * Metodo que intercambia los valores dentro del arreglo
     * @param pPadre
     * @param pHijo
     */
    public void intercambiar(int pPadre,int pHijo){
        
       MyDoc pDato1 = _arreglo.datoIndice(pPadre);
       MyDoc pDato2 = _arreglo.datoIndice(pHijo);
       
        _arreglo.setDatoIndice(pDato1, pHijo);
        _arreglo.setDatoIndice(pDato2, pPadre);
        
    }

    /**
     * Metodo que inserta elementos en el arreglo heap
     * @param pDato
     */
    public void insertar(MyDoc pDato){
        _arreglo.insertarFinal(pDato);
        this.heapMayores();
        
        
    }

    /**
     * Metodo que verifica si el padre es mayor que los hijos sino los intercambian
     * @param pIndice
     * @return
     */
    public boolean  verificarMayores(int pIndice){
        if(((pIndice*2)+1)<_arreglo.getCantidadElementos() && ((pIndice*2)+2)<_arreglo.getCantidadElementos()  ){
                 
           
            if(_arreglo.datoIndice(pIndice).compareTo(_arreglo.datoIndice((pIndice*2)+1))<0){
                intercambiar(pIndice,(pIndice*2)+1);
                if(_arreglo.datoIndice((pIndice*2)+2).compareTo(_arreglo.datoIndice((pIndice*2)+1))<0){
                    intercambiar((pIndice*2)+1,(pIndice*2)+2);
        
                }
                return true;

            }
            
         if(_arreglo.datoIndice(pIndice).compareTo(_arreglo.datoIndice((pIndice*2)+2))<0){
                intercambiar(pIndice,(pIndice*2)+1);
                if(_arreglo.datoIndice((pIndice*2)+2).compareTo(_arreglo.datoIndice((pIndice*2)+1))<0){
                    intercambiar((pIndice*2)+1,(pIndice*2)+2);
                }
                return true;
                
            }
         }
        return false;
            
             
             
       
        
        
        
        
        
        
    }

    /**
     * Metodo que imprime el arreglo 
     */
    public void imprimir(){
        _arreglo.imprimir();
        
    }

    /**
     * Metodo que verifica el arreglo y realiza el heap de mayores
     */
    public void heapMayores(){
        int i=0;
        
        int potencia=  (int)Math.pow(2,(int)Math.sqrt(_arreglo.getCantidadElementos()))-1;
        
        while(i<potencia){
            if(verificarMayores(i)){
                //System.out.println("iteracion: "+i);
                //_arreglo.imprimir();
                //verificarMayores(i);
                
            
            }
            else {
                verificarInverso();
            }
            i++;
                
            
            
            
            
        }
        
    }
        
    /**
     * Metodo que devuelve la raiz del heap
     * @return
     */
    public MyDoc obtenerDato(){
        MyDoc data=(MyDoc)_arreglo.getHead().getDato();
        _arreglo.borrarInicio();
        return data;
        
    }   
        
    /**
     * Metodo que verifica desde las hojas con menor nivel hasta la raiz que sean menores que la raiz
     
     */
    public void verificarInverso(){
        for(int i=_arreglo.getCantidadElementos()-1;0<i;i--){
            
            if(_arreglo.datoIndice(( ( i + 1 ) / 2 ) - 1).compareTo(_arreglo.datoIndice(i))<0){
               intercambiar(( ( i + 1 ) / 2 ) - 1,i);
               
               
           }
        }
        
    
}
   
        
    }
    
    
    