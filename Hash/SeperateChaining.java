package Hash;

import LinkedList.CDLinkedList;
import LinkedList.DListIterator;

public class SeperateChaining {
    private static int DEFAULT_SIZE = 101;
    private static int MAXLOAD = 2;
    private CDLinkedList[] lists;
    private int currentSize =0;

    public SeperateChaining(){
        this(DEFAULT_SIZE);
    }

 public SeperateChaining(int size){
    int nextPrimeSize = nextPrime(size);
    lists = new CDLinkedList[nextPrimeSize];
    for(int i=0; i<lists.length; i++){
    lists[i] = new CDLinkedList();
    }
 }

    private static boolean isPrime(int n){
        if(n == 2 || n == 3) if(n == 1 || n % 2 == 0)
        return false;
        for(int i = 3; i*i <= n; i+= 2)
        if(n%i == 0)
        return false;
        return true;
    }

    private static int nextPrime(int n){
        if(n % 2 == 0)
        n++;
        for( ; !isPrime(n); n += 2 ){}
        return n;
            
    }
    public int hash(Object data){
         int hashValue = data.hashCode();
         int abs = Math.abs(hashValue);
         return abs%lists.length;
    }
    public int find(int data) throws Exception{
         int pos = hash(data);
         CDLinkedList theList = lists[pos];
         return theList.find(data);
    }  
    public void add(int data) throws Exception {
         int pos = hash(data);
         CDLinkedList theList = lists[pos];
         if(theList.find(data) == -1){ // not found
         DListIterator itr =
         new DListIterator(lists[pos].header);
         lists[pos].insert(data, itr);
         currentSize++;
         }
         if(currentSize/lists.length >= MAXLOAD){
         rehash();
         }
         }
        
         public void rehash() throws Exception {
         CDLinkedList[] oldLists = lists;
         int newLength = nextPrime(2*lists.length);
         lists = new CDLinkedList[newLength];
         for(int i=0; i<lists.length; i++){
         lists[i] = new CDLinkedList();
         }
         for(int i=0; i<oldLists.length; i++){
         DListIterator itr;
         itr = new DListIterator(oldLists[i].header);
         while(itr.currentNode.nextNode !=
         oldLists[i].header){
         add(itr.next());
         }
         }
         } 
    public void remove(int data) throws Exception{
         int pos = hash(data);
         CDLinkedList theList = lists[pos];
        if(theList.find(data) != -1){ //data found
        theList.remove(data);
        currentSize--;
        }
    }
}