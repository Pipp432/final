package Hash;

public class Main {
    public static void main(String args[]) throws Exception{
        DoubleHashing hashTable = new DoubleHashing();
        hashTable.add(5);
        hashTable.add(16);
        hashTable.add(27);
        hashTable.add(9);
        hashTable.remove(16);
        hashTable.add(20);
        hashTable.add(16);
      
        
       
        for(Object e: hashTable.array){
            System.out.println(e);
        }
    }
    
}
