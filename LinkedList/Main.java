package LinkedList;

public class Main {
    public static void main(String args[] ) throws Exception{
        CDLinkedList list1 = new CDLinkedList();
        CDLinkedList list2 = new CDLinkedList();
        list1.insert(2, new DListIterator(list1.header));
        list1.insert(4, new DListIterator(list1.header));
        list1.insert(5, new DListIterator(list1.header));
        list1.insert(7, new DListIterator(list1.header));
        list1.insert(1, new DListIterator(list1.header));
        list2.insert(10, new DListIterator(list2.header));
        list2.insert(8, new DListIterator(list2.header));
        list2.insert(6, new DListIterator(list2.header));
        list2.insert(4, new DListIterator(list2.header));
        list2.insert(2, new DListIterator(list2.header));
        //  list1.printList();
        // list2.printList();
        // System.out.println();   
        list1.insertionSort();
        list1.printList();

        
       
    }
    
}
