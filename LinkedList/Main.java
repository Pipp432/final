package LinkedList;

public class Main {
    public static void main(String args[] ) throws Exception{
        CDLinkedList list1 = new CDLinkedList();
        CDLinkedList list2 = new CDLinkedList();
        list1.insert(0, new DListIterator(list1.header));
        list1.insert(1, new DListIterator(list1.header));
        list1.insert(2, new DListIterator(list1.header));
        list1.insert(3, new DListIterator(list1.header));
        list1.insert(4, new DListIterator(list1.header));
        list1.insert(6, new DListIterator(list1.header));
        list2.insert(10, new DListIterator(list2.header));
        list2.insert(8, new DListIterator(list2.header));
        list2.insert(6, new DListIterator(list2.header));
        list2.insert(4, new DListIterator(list2.header));
        list2.insert(2, new DListIterator(list2.header));
          list1.printList();
        // list2.printList();
         System.out.println();   
        list1.selectionSort();
        list1.printList();
        System.out.println();
        DListIterator iter = new DListIterator(list1.header.nextNode);
        DListIterator iter1 = new DListIterator(list1.header.nextNode);
        DListIterator iter2 = new DListIterator(list1.header.nextNode);
        while(iter2.currentNode!=list1.header){
            iter2.next();
        }
        list1.quickSort(iter1,iter2);
        while(iter.currentNode!=list1.header){
            System.out.println(iter.currentNode.data);
           iter.next();
        }
        // DListIterator iter = new DListIterator(list1.header.nextNode);
        // DListIterator iter2 = new DListIterator(list1.header.nextNode.nextNode);
        //  System.out.println(iter.currentNode.data);
        // list1.removeAt(iter);
        //  System.out.println(iter2.currentNode.data);
        // list1.insert(iter.currentNode.data, iter2);
        
        // // System.out.println();
        // list1.printList();

        
       
    }
    
}
