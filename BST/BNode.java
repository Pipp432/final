package BST;

public class BNode {
    int data; //the value that the node stores.
    BNode left;
    BNode right;
    BNode parent; 

    public BNode merge(BNode n1,BNode n2){
        if(n1==null && n2==null) return null;
        if(n1==null) return n2;
        if(n2==null) return n1;
        if(n1.data<n2.data);
        return null;
        

    }
    
}
