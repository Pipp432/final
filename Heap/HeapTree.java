package Heap;

import java.util.ArrayList;
import java.util.List;

import Sorting.ArrayPrinter;

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
   public int[] toArray(HeapNode node){
      if(node ==null) return null;
      List<Integer> list = new ArrayList<>();
      return toArray(node,list);


   }
   public int[] toArray(HeapNode node, List<Integer> list){
      if(node == null) return  null;
     
      list.add(node.data);
      toArray(node.left,list);
      toArray(node.right,list);
      int[] array  = new int[list.size()];
      int i = 0;
      for(int e:list){
         array[i++] = e; 
         
      }
      return array;

   }
   
   public boolean isHeap(HeapNode node){
      if(node==null) return true;
      if(node.left!=null && node.left.data<node.data) return false;
      if(node.right!=null && node.right.data <node.data) return false;
      return isHeap(node.left) && isHeap(node.right);

   }  
   public int top(){
      if(root==null) return-1;
      return root.data;

   }
   public int pop(){
      if(root==null) return -1;
      int result = root.data;
      root.data = 10;
      percolateDown();

      return result;
   }
   public static void main(String args[]){
      HeapTree tree = new HeapTree();
      HeapNode root = new HeapNode(7,null);
      ArrayPrinter ap = new ArrayPrinter();
      tree.root = root;
      root.left = new HeapNode(10,root);
      
      root.right = new HeapNode(13,root);
      
      root.left.left = new HeapNode(11,root.left);
      
      root.left.right = new HeapNode(12,root.left);
     
      System.out.println(root.data);
      System.out.println(root.left.data);
      System.out.println(root.right.data);
      System.out.println(root.left.left.data);
      System.out.println(root.left.right.data);
      System.out.println(tree.isHeap(tree.root));
     
      System.out.println("============================");
      // tree.percolateDown();
      tree.percolateUp(tree.root.left.left);
      tree.percolateUp(tree.root.left.left);
     
      System.out.println(root.data);
      System.out.println(root.left.data);
      System.out.println(root.right.data);
      System.out.println(root.left.left.data);
      System.out.println(root.left.right.data);
      System.out.println(tree.isHeap(tree.root));
      int[] arr = tree.toArray(tree.root.right);
      ap.printArray(arr);

   }
    
    

}
    

