/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Isaac Núñez
 * @param <AbstractData>
 */
public class Nodo_AVL<AbstractData extends Comparable<AbstractData>> implements Comparable<Nodo_AVL<AbstractData>>{
    private Nodo_AVL<AbstractData> _padre;
    private Nodo_AVL<AbstractData> _hder;
    private Nodo_AVL<AbstractData> _hizq;
    private AbstractData _datos;
    private int _altura;
    private int _balace;
    
    /**
     * class constructor
     */
    public Nodo_AVL(){
        this._padre = null;
        this._hizq = null;
        this._hder = null;
    }
    /**
     * Es donde se crea el nodo
     * @param pDato 
     */
    public Nodo_AVL(AbstractData pDato){
        this._datos = pDato;
        this._padre = null;
        this._altura = 0;
        this._balace = 0;
    }
    /**
     * metodo que nos permite saber cual es el padre del nodo
     * @return 
     */

    public Nodo_AVL getPadre() {
        return _padre;
    }
    /**
     * Agregarmos el valor del padre
     * @param _padre 
     */

    public void setPadre(Nodo_AVL<AbstractData> _padre) {
        this._padre = _padre;
    }
    /**
     * Nos retorna el hijo derecho del nodo
     * @return 
     */

    public Nodo_AVL<AbstractData> getHder() {
        return _hder;
    }
    /**}
     * añadimos la referencia al hijo derecho
     * @param _hder 
     */

    public void setHder(Nodo_AVL<AbstractData> _hder) {
        this._hder = _hder;
    }
    /**
     * nos retorna el hijo izquierdo
     * @return 
     */

    public Nodo_AVL<AbstractData> getHizq() {
        return _hizq;
    }
    /**
     * creamos la referencia hacia el hijo izquierdo
     * @param _hizq 
     */

    public void setHizq(Nodo_AVL<AbstractData> _hizq) {
        this._hizq = _hizq;
    }
    /**
     * obtenemos la información de cada nodo
     * @return 
     */

    public AbstractData getDatos() {
        return _datos;
    }
    /**
     * insertamos la informacion a cada nodo
     * @param _datos 
     */

    public void setDatos(AbstractData _datos) {
        this._datos = _datos;
    }
    /**
     * nos retorna el valor de la altura de cada nodo
     * @return 
     */

    public int getAltura() {
        return _altura;
    }
    /**
     * insertamos el valor de la altura a cada nodo
     * @param _altura 
     */

    public void setAltura(int _altura) {
        this._altura = _altura;
    }
    /**
     * obtenemos el factor de equilibrio de cada nodo
     * @return 
     */

    public int getBalace() {
        return _balace;
    }
    /**
     * insertamos el factor de equilibrio a cada nodo
     * @param _balace 
     */

    public void setBalace(int _balace) {
        this._balace = _balace;
    }
    /**
     * es el método que compara datos abstractos.
     * @param o
     * @return 
     */

    public int compareTo(Nodo_AVL<AbstractData> o) {
        return o.getDatos().compareTo(_datos);
    }



    
}
