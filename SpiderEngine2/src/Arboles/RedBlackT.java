/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import EstructurasDeDatos.*;

/**
 *
 * @author bryan
 * @param <datoAbstracto>
 */
public class RedBlackT<datoAbstracto extends Comparable<datoAbstracto>> {

private  char BLACK = 'B';

private  char RED = 'R';
        ListaCircularDoble<datoAbstracto> data = new ListaCircularDoble();

private NodeRB<datoAbstracto> root;

    /**
     *
     */
    public RedBlackT() {
    root = null;
}

    /**
     *
     * @return
     */
    public NodeRB<datoAbstracto> getRoot(){
    return root;
}

    /**
     *
     * @param data
     * @throws IllegalArgumentException
     */
    public void insert(datoAbstracto data) throws IllegalArgumentException {
    try {
        root = insert_aux( root, data );
        root.setColour( BLACK );
    } catch(IllegalArgumentException e) {
        throw e;
    }
}


private NodeRB<datoAbstracto> insert_aux( NodeRB<datoAbstracto> node, datoAbstracto data ) throws IllegalArgumentException {
    if( node == null ) {
        NodeRB<datoAbstracto> newNode = new NodeRB<datoAbstracto>(data);
        return newNode;
    }
    int cmp = data.compareTo( node.getData() );

    if( cmp < 0 ) {
        node.setLeftChild( insert_aux( node.getLeftChild(), data ) );
    } else if( cmp > 0 ) {
        node.setRightChild( insert_aux( node.getRightChild(), data ) );
    } else {
       // System.out.println("Already Exist");
    }

    if( isRed( node.getLeftChild() ) && isRed( node.getLeftChild().getLeftChild() ) ) {
        node.setColour( RED );
        node.getLeftChild().setColour( BLACK );
        node = rightRotation(node);
    }

    if( isRed( node.getRightChild() ) && isRed( node.getRightChild().getRightChild() ) ) {
        node.setColour( RED );
        node.getRightChild().setColour( BLACK );
        node = leftRotation(node);
    }

    if( isRed( node.getLeftChild() ) && isRed( node.getLeftChild().getRightChild() ) ) {
        node.setColour( RED );
        node.getLeftChild().getRightChild().setColour( BLACK );
        node.setLeftChild( leftRotation(node.getLeftChild() ) );
        node = rightRotation( node );
    }

    if( isRed( node.getRightChild() ) && isRed( node.getRightChild().getLeftChild() ) ) {
        node.setColour( RED );
        node.getRightChild().getLeftChild().setColour( BLACK );
        node.setRightChild( rightRotation( node.getRightChild() ) );
        node = leftRotation( node );
    }

    colourFlip(node);
    return node;
}

    /**
     *
     * @param data
     * @return
     */
    public NodeRB<datoAbstracto> contains(datoAbstracto data) {
    NodeRB<datoAbstracto> current = root;
    while( data.compareTo(current.getData()) != 0 ) {
        if( data.compareTo(current.getData()) < 0 ) {
            current = current.getLeftChild();
        } else {
            current = current.getRightChild();
        }
        if( current == null) {
            return null;
        }
    }
    return current;
}
    public void getData(){
            getData_aux(root);}

    public ListaCircularDoble<datoAbstracto> getData_aux(NodeRB subtree){
        NodeRB<datoAbstracto> current = subtree;
        if(current==null){
            return data;}
        else{
            
            if(current.getLeftChild()!=null && current.getRightChild()!=null){
            data.insertarFinal(current.getLeftChild().getData());
            data.insertarFinal(current.getRightChild().getData());
                getData_aux(current.getLeftChild());
                getData_aux(current.getRightChild());}
            else{
                data.imprimir();
            return data;}
    data.imprimir();
    return data;
    }}


    /**
     *
     * @param node
     * @return
     */
    public boolean isRed( NodeRB<datoAbstracto> node ) {
    if( node == null ) {
        return false;
    }
    return node.getColour() == RED;
}

private void colourFlip( NodeRB<datoAbstracto> parent ) {
    if( parent.getRightChild() == null ||
            parent.getLeftChild() == null ) {
        return;
    }

    if( !isRed(parent) && isRed(parent.getRightChild())
    && isRed(parent.getLeftChild()) ) {
        if( parent != root ) {
            parent.setColour( RED );
        }
        parent.getRightChild().setColour( BLACK );
        parent.getLeftChild().setColour( BLACK );
    }
}


private NodeRB<datoAbstracto> rightRotation( NodeRB<datoAbstracto> grandparent ) {
    NodeRB<datoAbstracto> parent = grandparent.getLeftChild();
    NodeRB<datoAbstracto> rightChildOfParent = parent.getRightChild();
    parent.setRightChild( grandparent );
    grandparent.setLeftChild( rightChildOfParent );
    return parent;
}


private NodeRB<datoAbstracto> leftRotation( NodeRB<datoAbstracto> grandparent ) {
    NodeRB<datoAbstracto> parent = grandparent.getRightChild();
    NodeRB<datoAbstracto> leftChildOfParent = parent.getLeftChild();
    parent.setLeftChild( grandparent );
    grandparent.setRightChild( leftChildOfParent );
    return parent;
}
}
