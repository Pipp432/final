package Hash;

import java.util.HashSet;


public class Hash {
    public static void main (String args[]){

    }
    public int[] intersection(int[] arr1,int[] arr2){
       HashSet<Integer> hash1 = new HashSet<>();
       HashSet<Integer> hash2 = new HashSet<>();
       for(int e: arr1) hash1.add(e);
       for(int e: arr2) hash2.add(e);

       hash1.retainAll(hash2);

       int[] output = new int[hash1.size()];
       int index=0;
       for(int s : hash1) output[index++] = s;
       return output;
       


    }
    
}
