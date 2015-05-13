/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;
/**
 *
 * @author bryan
 * @param <datoAbstracto>
 */
public class NodeRB<datoAbstracto extends Comparable< datoAbstracto >> {
    private  char RED = 'R';

private char BLACK = 'B';

private datoAbstracto data;

private char colour;

private NodeRB<datoAbstracto> rightChild;

private NodeRB<datoAbstracto> leftChild;


private boolean deleted;

    /**
     *
     * @param data
     */
    public NodeRB(datoAbstracto data) {
    this.data = data;
    colour = RED;
    rightChild = null;
    leftChild = null;
    deleted = false;
}

    /**
     *
     * @param data
     */
    public void setData(datoAbstracto data){
    this.data = data;
}

    /**
     *
     * @param c
     * @return
     */
    public boolean setColour( char c ) {
    
    if( ( c == RED || c == BLACK ) && c != colour ) {
        colour = c;
        return true;
    }
    return false;
}

    /**
     *
     * @param node
     */
    public void setLeftChild( NodeRB<datoAbstracto> node ) {
    leftChild = node;
}

    /**
     *
     * @param node
     */
    public void setRightChild( NodeRB<datoAbstracto> node ) {
    rightChild = node;
}



    /**
     *
     * @return
     */
    public datoAbstracto getData() {
    return data;
}

    /**
     *
     * @return
     */
    public char getColour() {
    return colour;
}

    /**
     *
     * @return
     */
    public NodeRB<datoAbstracto> getLeftChild() {
    return leftChild;
}

    /**
     *
     * @return
     */
    public NodeRB<datoAbstracto> getRightChild() {
    return rightChild;
}

}


