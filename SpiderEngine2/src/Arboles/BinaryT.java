package Arboles;

/**
 *
 * @author bryan
 * @param <datoAbstracto>
 */
public class BinaryT<datoAbstracto extends Comparable<datoAbstracto>> {
	private NodeB<datoAbstracto> root;
        int elements =0;
	
    /**
     *
     */
    public BinaryT() {
    root = null;
    }
     
    
    /**
     *
     * @return
     */
    public NodeB<datoAbstracto> getRoot(){
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
        } catch(IllegalArgumentException e) {
            throw e;
        }
    }
    
    private NodeB<datoAbstracto> insert_aux( NodeB<datoAbstracto> node, datoAbstracto data ) throws IllegalArgumentException {
        if( node == null ) {
            NodeB<datoAbstracto> newNode = new NodeB(data);
            this.elements+=1;
            return newNode;
        }
        int cmp = data.compareTo( node.getData() );

        if( cmp < 0 ) {
            node.setLeftChild( insert_aux( node.getLeftChild(), data ) );
            this.elements+=1;
        } else if( cmp > 0 ) {
            node.setRightChild( insert_aux( node.getRightChild(), data ) );
            this.elements+=1;
        } else {
           // System.out.println("Already Exist");
        }

        return node;
    }
    
    /**
     *
     * @param data
     * @return
     */
    public NodeB<datoAbstracto> contains(datoAbstracto data) {
        NodeB<datoAbstracto> current = root;
        if(!isEmpty()){
            
        
    while( data.compareTo(current.getData()) != 0 ) {
        if( data.compareTo(current.getData()) < 0 ) {
            current = current.getLeftChild();
        } else {
            current = current.getRightChild();
        }
        if( current == null) {
            System.out.println("Element not founded");
            return null;
        }
    }
    return current;}
        else return null;
}
    
    /**
     *
     */
    public void inOrder(){
        inOrder_aux(root);
    }

    private void inOrder_aux(NodeB root){
        if( root.getLeftChild() !=null)
            this.inOrder_aux(root.getLeftChild());
        System.out.println(root.getData());

        if( root.getRightChild() != null)
            this.inOrder_aux(root.getRightChild());
    
        
}

    /**
     *
     * @param data
     */
    public void delete(datoAbstracto data) {
        deleteNode(root,data);
    }

    private NodeB<datoAbstracto> deleteNode(NodeB<datoAbstracto> subtree,  datoAbstracto data) {
        if (subtree != null) {
            if (subtree.getData().compareTo(data) < 0) {
                subtree.setRightChild(deleteNode(subtree.getRightChild(), data));
            } else if (subtree.getData().compareTo(data) > 0) {
                subtree.setLeftChild(deleteNode(subtree.getLeftChild(), data));
                
            } else {
               
                if ((subtree.getLeftChild() != null) && (subtree.getRightChild() != null)) {
                    NodeB<datoAbstracto> tmp = findLeftmostChild(subtree.getRightChild());
                    subtree.setData(tmp.getData());
                    subtree.setRightChild(deleteNode(subtree.getRightChild(),tmp.getData()));
                } else if (subtree.getLeftChild() != null) {
                            subtree.setData(subtree.getLeftChild().getData());
                } else {
                    subtree.setData(subtree.getRightChild().getData());    
                }
            }
            
        } else{
            System.out.println("Data doesn't exist");
        }
        return subtree;
    }
    

    private NodeB<datoAbstracto> findLeftmostChild(NodeB<datoAbstracto> subtree){
        assert (subtree != null);
        while (subtree.getLeftChild() != null) {
            subtree = subtree.getLeftChild();
        }
        return subtree;
    }
    public boolean isEmpty(){
        return this.root==null;
    }

    
}
