package Heap;

public class HeapTree {
   public HeapNode root;
   
   public void percolateDown(){
      if(root==null) return;
      HeapNode current = root;
      while(current.left!=null||current.right!=null){
         HeapNode left = current.left;
         HeapNode right = current.right;

         if(left==null&&right!=null){
            if(current.data>right.data){
               int temp = current.data;
               current.data = right.data;
               right.data = temp;
               current = right;
            }
         }
         else if(left!=null&&right==null){
            if(current.data>left.data){
               int temp = current.data;
               current.data = left.data;
               left.data = temp;
               current = left;
            }
         }else{
            if(current.data>left.data||current.data>right.data){
            
               if(left.data<right.data){
                  int temp = current.data;
                  current.data = left.data;
                  left.data = temp;
                  current = left;
      
               }else{
                 
                  int temp = current.data;
                  current.data = right.data;
                  right.data = temp;
                  current = right;
               }
   
            }else{
               break;
            }

         }

         
         
         
      }
      
   }
   public static void main(String args[]){
      HeapTree tree = new HeapTree();
      HeapNode root = new HeapNode(12);
      root.left = new HeapNode(1);
      root.right = new HeapNode(8);
      root.right.left = new HeapNode(10);
      root.right.right = new HeapNode(11);
      tree.root = root;
      
      tree.percolateDown();
     
      System.out.println(root.data);
      System.out.println(root.right.data);
      System.out.println(root.right.left.data);
      System.out.println(root.right.right.data);
   }
    
    

}
    

