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
public class Splay <AbstractData extends Comparable<AbstractData>>{
    
    private Nodo_AVL<AbstractData> _root;
    
    /**
     * Class Constructor
     */
    private void Splay(){
        this._root = null;
        
    }
    /**
     * Es el método que nos permite saber si el árbol es nulo.
     * @return boolean
     */
    private boolean IsEmpty(){
        return this._root == null;
    }
    
    /**
     * Inserta el dato que ingresa, si la raiz es nula, lo inserta ahí
     * sino hace una llamada auxiliar.
     * @param pDato 
     */
    public void Insertar (AbstractData pDato){
        Nodo_AVL pNodo = new Nodo_AVL(pDato);
        if (this._root == null)
            this._root = pNodo;
        else
            Insertar_Aux(pNodo, this._root);
    }
    /**
     * Es el método auxiliar, el cual ingresa en los demás nodos si la raiz esta llena
     * y hace las rotaciones para llevarlo a la raíz del árbol.
     * @param pNodo
     * @param pRoot 
     */
    private void Insertar_Aux(Nodo_AVL pNodo, Nodo_AVL pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getHizq() == null){
                pRoot.setHizq(pNodo);
                pNodo.setPadre(pRoot);
                this.Splay(pNodo);
            }else
                Insertar_Aux(pNodo, pRoot.getHizq());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getHder() == null){
                pRoot.setHder(pNodo);
                pNodo.setPadre(pRoot);
                this.Splay(pNodo);
            }else
                Insertar_Aux(pNodo, pRoot.getHder());
        }else
            System.out.println("Está repetido");
    }
    /**
     * Es el método que nos permite hacer las rotaciones con metodos auxiliares
     * @param pNodo 
     */
    private void Splay(Nodo_AVL pNodo){
        while (pNodo.getPadre() != null){
            Nodo_AVL parent = pNodo.getPadre();
            Nodo_AVL grandparent = parent.getPadre();
            if (grandparent == null){
                if (parent.getHizq() == pNodo){
                    this.IzqToParent(pNodo, parent);
                }else{
                    this.DerToParent(pNodo, parent);
                }
            }else{
                if (parent.getHizq() == pNodo){
                    if (grandparent.getHizq() == parent){
                        this.IzqToParent(parent, grandparent);
                        this.IzqToParent(pNodo, parent);
                    }else{
                        this.IzqToParent(pNodo, parent);
                        this.DerToParent(pNodo, parent);
                    }
                }else{
                    if (grandparent.getHizq() != parent){
                        this.DerToParent(parent, grandparent);
                        this.DerToParent(pNodo, parent);
                    }else{
                        this.DerToParent(pNodo, parent);
                        this.IzqToParent(pNodo, parent);
                    }
                }
            }
        }
        this._root = pNodo;
    }
    /**
     * Si el nodo reciente queda como hijo izquierdo, al hacerle splay, este quedará 
     * como el padre y su padre pasará a ser su hijo derecho.
     * @param pNodo
     * @param Parent 
     */
    private void IzqToParent(Nodo_AVL pNodo, Nodo_AVL Parent){
        if (Parent.getPadre() != null){
            if (Parent == Parent.getPadre().getHizq()){
                Parent.getPadre().setHizq(pNodo);
            }else
                Parent.getPadre().setHder(pNodo);
        }
        
        if (pNodo.getHder() !=null){
            pNodo.getHder().setPadre(Parent);
        }
        
        pNodo.setPadre(Parent.getPadre());
        Parent.setPadre(pNodo);
        pNodo.setHder(Parent.getHizq());
        pNodo.setHder(Parent);
    }
    /**
     * Si el nodo reciente queda como hijo derecho, al hacerle splay, este quedará 
     * como el padre y su padre pasará a ser su hijo izquierdo.
     * @param pNodo
     * @param Parent 
     */
    private void DerToParent(Nodo_AVL pNodo, Nodo_AVL Parent){
        if (Parent.getPadre() != null){
            if (Parent == Parent.getPadre().getHder()){
                Parent.getPadre().setHder(pNodo);
            }else
                Parent.getPadre().setHizq(pNodo);
        }
        
        if (pNodo.getHizq() != null){
            pNodo.getHizq().setPadre(Parent);
        }
        
        pNodo.setPadre(Parent.getPadre());
        Parent.setPadre(pNodo);
        pNodo.setHizq(Parent.getHder());
        pNodo.setHizq(Parent);
    }
    
    /**
     *Es el encargado de buscar mediante un método auxiliar si el nodo existe.
     * @param pDato
     */
    public void Search(AbstractData pDato){
        Nodo_AVL<AbstractData> pNodo = new Nodo_AVL();
        Buscar_aux(pNodo, _root);
    }
    /**
     * Es el método auxuliar en el cual si encuentra el nodo, le hace splay al nodo 
     * que contiene la información que se desea.
     * @param pNodo
     * @param pRoot 
     */
    private void Buscar_aux(Nodo_AVL pNodo, Nodo_AVL pRoot){
        if (pNodo.compareTo(pRoot) < 0){
            if (pRoot.getHder()==null){
                this.Splay(this.Find_min(this._root));
            }else
                Buscar_aux(pNodo, pRoot.getHizq());
        }else if (pNodo.compareTo(pRoot) > 0){
            if (pRoot.getHder() == null){
                this.Splay(this.Find_max(this._root));
            }else
                Buscar_aux(pNodo, pRoot.getHder());
        }else
            this.Splay(pRoot);
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
}
