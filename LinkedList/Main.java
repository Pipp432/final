package LinkedList;

public class Main {
    public static void main(String args[] ) throws Exception{
        CDLinkedList list = new CDLinkedList();
        DListIterator p = new DListIterator(list.header);
        DListIterator s = new DListIterator(list.header.nextNode);
        DListIterator q = new DListIterator(list.header);
        p.next();
        list.insert(10, p);
        p.next();
        list.insert(11, p);
        p.next();
        list.insert(2, p);
        p.next();
        list.insert(0, p);
        p.next();
        list.insert(9, p);
        p.next();
        list.insert(-1, p);
        p.next();
        list.insert(17, p);
        
        while(q.currentNode.nextNode!= list.header){
            q.next();
        }
        // System.out.println(q.currentNode.data);

        list.quickSort();
      
         
         list.printList();
        
       
    }
    
}