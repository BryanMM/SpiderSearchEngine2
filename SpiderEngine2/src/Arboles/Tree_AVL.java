/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import EstructurasDeDatos.*;
import Logica.Keyword;

/**
 *@param <AbstractData>
 * @author Isaac Núñez
 */
public class Tree_AVL<AbstractData extends Comparable<AbstractData>>  {
    private Nodo_AVL<AbstractData> _root;
    private int CantEle;

    /**
     * Class Constructor 
     */
    public void Tree_AVL(){
        this._root = null;
        this.CantEle = 0;

    }

    public int getCantEle() {
        return CantEle;
    }
    /**
     * Es el método que nos permite saber si el árbol es nulo.
     * @return boolean
     */

    public boolean Tree_Empty(){
        return this._root == null;
    }
    /**
     * Inserta el dato que ingresa, si la raiz es nula, lo inserta ahí
     * sino hace una llamada auxiliar.
     * @param pDato 
     */
    public void Inserta_AVL(AbstractData pDato){
        Nodo_AVL<AbstractData> pNodo = new Nodo_AVL(pDato);
        if (_root == null){
            _root = pNodo;
            this.CantEle += 1;
        }
        else
            Inserta_AVLaux(pNodo, _root);
    }
    /**
     * Método auxiliar el cual se encarga de insertar en los demás nodos si la raíz es llena.
     * @param pNodo
     * @param pRoot 
     */
    public void Inserta_AVLaux(Nodo_AVL pNodo, Nodo_AVL pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getHder() == null){
                pRoot.setHder(pNodo);
                pNodo.setPadre(pRoot);
                balance_right(pNodo);
                this.CantEle += 1;
            }else
                Inserta_AVLaux(pNodo, pRoot.getHder());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getHizq() == null){
                pRoot.setHizq(pNodo);
                pNodo.setPadre(pRoot);
                balance_right(pRoot);
                this.CantEle += 1;
            }else
                Inserta_AVLaux(pNodo, pRoot.getHizq());
        }
           // System.out.println("Está repetido");
        
    }
    /**
     * es el método que se encarga de hacer una llamada auxiliar para poder hacer las búsquedas.
     * @param pIncog 
     */
    public void Busqueda(AbstractData pIncog){
        try{
            Nodo_AVL<AbstractData> Infog = new Nodo_AVL(pIncog);
            Busqueda_Aux(Infog, _root);
            System.out.println(Busqueda_Aux(Infog,_root).getDatos());
        }catch(NullPointerException e){
            
        }
    }
    /**
     * método que se encarga de hacer las rotaciones de acuerdo al valor de equilibrio.
     * @param pNodo
     * @return 
     */
    private Nodo_AVL balance_right(Nodo_AVL pNodo){
        try{
            if (pNodo == null)
                return null;

            balance_factor(pNodo);
            int fe = pNodo.getBalace();

            if (fe == -2){
                if (altura(pNodo.getHizq().getHizq())>=altura(pNodo.getHizq().getHder()))
                    return pNodo = Rota_derecha(pNodo);
                else
                    return pNodo = Rotar_IzqDer(pNodo);
            }else if(fe ==2){
                if (altura(pNodo.getHder().getHder())>=altura(pNodo.getHder().getHizq()))
                    return pNodo = Rota_Izquierda(pNodo);
                else
                    return pNodo = Rotar_DerIzq(pNodo);
            }

            if (pNodo.getPadre() != null)
                balance_right(pNodo.getPadre());
            else
                this._root = pNodo;
            
        }catch(NullPointerException e){
        }
        return pNodo;
    }
    /**
     * método auxiliar el cual busca el nodo si existe en el árbol.
     * @param Infog
     * @param pRoot
     * @return 
     */
    private Nodo_AVL Busqueda_Aux(Nodo_AVL Infog,Nodo_AVL pRoot){
        if (pRoot == null)
            return null;
        else if (Infog.compareTo(pRoot)>0)
            return Busqueda_Aux(Infog, pRoot.getHizq());
        else if (Infog.compareTo(pRoot)<0){
            return Busqueda_Aux(Infog, pRoot.getHder());
        }else
            return Infog;
                
        
    }
    /**
     * Es el metodo que determina la altura de cada nodo.
     * @param pNodo
     * @return 
     */
    public int altura(Nodo_AVL pNodo){
        if (pNodo == null || (pNodo.getHizq()== null && pNodo.getHder() == null))
            return -1;
        else if(pNodo.getHizq() == null)
            return 1 + altura(pNodo.getHder());
        else if (pNodo.getHder() == null)
            return 1 + altura(pNodo.getHizq());
        else{
            return 1 + altu_max(altura(pNodo.getHizq()),altura(pNodo.getHder()));
        }
    }
    /**
     * método auxiliar para determinar cual hijo es más profundo.
     * @param _hijo1
     * @param _hijo2
     * @return 
     */
    public int altu_max(int _hijo1, int _hijo2){
        if (_hijo1 > _hijo2)
            return _hijo1;
        else
            return _hijo2;
    }
    /**
     * En este método, le inserto el valor de balance al atributo del nodo dedicado
     * para eso.
     * @param pNodo 
     */
    public void balance_factor(Nodo_AVL pNodo){
       try{
           pNodo.setBalace(altura(pNodo.getHizq())-altura(pNodo.getHder()));
       }catch(NullPointerException n){
           System.out.println("Ya no existen más hijos");
       }
    }
    /**
     * Este método es el que se encarga de rotar hacia la derecha.
     * @param pNodo
     * @return 
     */
    public Nodo_AVL Rota_derecha(Nodo_AVL pNodo){
        if (pNodo == null)
            return null;
        
        Nodo_AVL tmp = pNodo.getHizq();
        tmp.setPadre(pNodo.getPadre());
        pNodo.setHizq(tmp.getHder());
        
        if (pNodo.getHizq() != null)
            pNodo.getHizq().setPadre(pNodo);
        tmp.setHder(pNodo);
        pNodo.setPadre(tmp);
        
        if (tmp.getPadre() != null)
            if (tmp.getPadre().getHizq() == pNodo){
                tmp.getPadre().setHizq(tmp);
            }else if(tmp.getPadre().getHder() == pNodo){
                tmp.getPadre().setHder(tmp);
            }
        
        balance_factor(pNodo);
        balance_factor(tmp);
     //   System.out.println("Se ha rotado a la derecha");
        return tmp;
    }
    /**
     * Es el método que se encarga de rotar hacia izquiera.
     * @param pNodo
     * @return 
     */
    public Nodo_AVL Rota_Izquierda(Nodo_AVL pNodo){
        if (pNodo == null)
            return null;
        
        Nodo_AVL tmp = pNodo.getHder();
        tmp.setPadre(pNodo.getPadre());
        pNodo.setHder(tmp.getHizq());
        
        if (pNodo.getHder() != null)
            pNodo.getHder().setPadre(pNodo);
        tmp.setHizq(pNodo);
        pNodo.setPadre(tmp);
        
        if (tmp.getPadre() != null)
            if (tmp.getPadre().getHder() == pNodo){
                tmp.getPadre().setHder(tmp);
            }else if(tmp.getPadre().getHizq() == pNodo){
                tmp.getPadre().setHizq(tmp);
            }
        
        balance_factor(pNodo);
        balance_factor(tmp);
      //  System.out.println("Se ha rotado a la izquierda");
        return tmp;
    }
    /**
     * Es el metodo que mediante dos llamadas auxiliares, hace dos rotaciones
     * la primera hacia la derecha y la siguiente hacia la izquierda.
     * @param pNodo
     * @return 
     */
    public Nodo_AVL Rotar_DerIzq(Nodo_AVL pNodo){
        pNodo.setHder(this.Rota_derecha(pNodo.getHder()));
        return this.Rota_Izquierda(pNodo);
    }
    /**
     * Es le método que mediante llamadas auxiliares, se encarga de hacer dos rotaciones
     * la primera hacia la izquierda y luego hacia la derecha.
     * @param pNodo
     * @return 
     */
    public Nodo_AVL Rotar_IzqDer(Nodo_AVL pNodo){
        pNodo.setHizq(this.Rota_Izquierda(pNodo.getHizq()));
        return this.Rota_derecha(pNodo);
    }
    /**
     * Es el metodo encargado de eliminar un nodo mediante una llamada auxiliar.
     * @param pDato 
     */
    public void Delete(AbstractData pDato){
        Nodo_AVL pNodo = new Nodo_AVL<AbstractData>( pDato);
        Delete_aux(pNodo, this._root);
    }
    /**
     * metodo auxiliar el cual se encarga de elimianr el nodo que contenga la 
     * información deseada.
     * @param pNodo
     * @param pRoot
     * @return 
     */
    public Nodo_AVL Delete_aux(Nodo_AVL pNodo,Nodo_AVL pRoot){
        if (pRoot == null)
            System.out.println("No está el dato");
        else if(pNodo.compareTo(pRoot) > 0)
            pRoot.setHizq(Delete_aux(pNodo, pRoot.getHizq()));
        else if (pNodo.compareTo(pRoot) < 0)
            pRoot.setHder(Delete_aux(pNodo, pRoot.getHder()));
        else if (pRoot.getHder() != null || pRoot.getHizq() != null){
            pRoot.setDatos(Find_min(pRoot.getHder()).getDatos());
            Nodo_AVL tmp = pRoot;
            pRoot.setHder(Delete_aux(pNodo, pRoot.getHder()));
        }
        return this.balance_right(pRoot);
    }
    /**
     * encuentra el nodo menor, partiendo de un nodo cualquiera.
     * @param pNodo
     * @return 
     */
    private Nodo_AVL Find_min(Nodo_AVL pNodo){
        if (pNodo == null)
            return null;
        else if (pNodo.getHizq() == null)
            return pNodo;
        return Find_min(pNodo.getHizq());
    }
    /**
     * encuentra el nodo mayor, partiendo de un nodo cualquiera.
     * @param pNodo
     * @return 
     */
    private Nodo_AVL Find_max(Nodo_AVL pNodo){
        if (pNodo == null)
            return null;
        else if (pNodo.getHder() == null)
            return pNodo;
        return Find_max(pNodo.getHder());
    }
    /**
     * Es el encargado de obtener los datos y meterlos en una lista circular doble
     * de manera ordenada, de menor a mayor mediante una llamada auxiliar
     * @return 
     */
    public synchronized ListaCircularDoble<Keyword>  Datos(){
        ListaCircularDoble<Keyword> keywords = new ListaCircularDoble();
        InOrder(_root, keywords);
        //keywords.imprimir();
        return keywords;
    }
    /**
     * Es la llamada auxiliar que permite obtener los métodos en orden de menor a mayor
     * y los inserta en una lista circular doble para luego ser utilizados en otros procesos.
     * @param pNodo
     * @param keywords
     * @return 
     */
    private ListaCircularDoble InOrder(Nodo_AVL<AbstractData> pNodo, ListaCircularDoble keywords){
        try{
            if (pNodo != null){
                InOrder(pNodo.getHizq(), keywords);
                keywords.insertarFinal(pNodo.getDatos());
                InOrder(pNodo.getHder(), keywords);
                
            }
                
        }catch(NullPointerException e){
        }
        return keywords; 

    }
}
    
