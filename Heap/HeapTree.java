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
   public void percolateUp(HeapNode node){
      
      while(node.parent!=null){
        
         if(node.data<node.parent.data){
            int temp = node.data;
            node.data = node.parent.data;
            node.parent.data = temp;
            node = node.parent;
         }else{
            break;
         }
      }

   }
   public static void main(String args[]){
      HeapTree tree = new HeapTree();
      HeapNode root = new HeapNode(7);
      tree.root = root;
      root.left = new HeapNode(10);
      root.left.parent = root;
      root.right = new HeapNode(13);
      root.right.parent = root;
      root.right.left = new HeapNode(15);
      root.right.left.parent = root.right;
      root.right.right = new HeapNode(12);
      root.right.right.parent = root.right;
      System.out.println(root.data);
      System.out.println(root.left.data);
      System.out.println(root.right.data);
      System.out.println(root.right.left.data);
      System.out.println(root.right.right.data);
     
      System.out.println("============================");
      // tree.percolateDown();
      tree.percolateUp(tree.root.right.right);
     
      System.out.println(root.data);
      System.out.println(root.left.data);
      System.out.println(root.right.data);
      System.out.println(root.right.left.data);
      System.out.println(root.right.right.data);
   }
    
    

}
    

