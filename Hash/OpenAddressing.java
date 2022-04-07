package Hash;

public class OpenAddressing {
    static int DEFAULT_SIZE = 101;
    static final Object DELETED = new Object();
    static double MAXFACTOR = 0.5;
    int currentSize =0;
    Object[] a;

    public OpenAddressing(){
        this(DEFAULT_SIZE);
    }
    public OpenAddressing(int size){
        int nextPrimeSize = Utility.nextPrime(size);
        a= new Object[nextPrimeSize];
    }
    
}
