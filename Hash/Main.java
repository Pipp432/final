package Hash;

public class Main {
    public static void main(String args[]) throws Exception{
        DoubleHashing hashTable = new DoubleHashing();
        hashTable.add(5);
        hashTable.add(10);
        hashTable.add(18);
        hashTable.add(19);
        hashTable.add(31);
        hashTable.remove(31);
        hashTable.add(32);
        
       
        for(Object e: hashTable.array){
            System.out.println(e);
        }
    }
    
}
