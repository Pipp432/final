package LinkedList;

public class Main {
    public static void main(String args[] ) throws Exception{
        CDLinkedList list = new CDLinkedList();
        DListIterator p = new DListIterator(list.header);
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
        // list.printList();
        list.mergeSort(list);
        // System.out.println("================");
        // list.printList();
        
       
    }
    
}
