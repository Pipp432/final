package Hash;

public class Main {
    public static void main(String args[]) throws Exception{
        DoubleHashing hashTable = new DoubleHashing();
        hashTable.add(3);
        hashTable.add(10);
        hashTable.add(2);
        hashTable.add(11);
        hashTable.add(21);
        for(Object e: hashTable.array){
            System.out.println(e);
        }
    }
    
}
