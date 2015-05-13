package Arboles;

public class NodeB<datoAbstracto extends Comparable< datoAbstracto >> {
	
	private datoAbstracto Data;
	
	private boolean deleted;
	
	private NodeB<datoAbstracto> rightChild;

	private NodeB<datoAbstracto> leftChild;
	
	public NodeB(datoAbstracto data) {
	    this.Data = data;
	}

	public void setData(datoAbstracto data){
	    this.Data = data;
	}

	public void setLeftChild( NodeB<datoAbstracto> node ) {
	    leftChild = node;
	}


	public void setRightChild( NodeB<datoAbstracto> node ) {
	    rightChild = node;
	}

	public datoAbstracto getData() {
	    return Data;
	}
	

	public NodeB<datoAbstracto> getLeftChild() {
	    return leftChild;
	}


	public NodeB<datoAbstracto> getRightChild() {
	    return rightChild;
	}


}




