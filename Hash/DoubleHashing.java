package Hash;

public class DoubleHashing extends OpenAddressing {
    static double MAXFACTOR = 0.75;
    int occupiedSlots = 0;

    public DoubleHashing(){
        this(DEFAULT_SIZE);
    }

    public DoubleHashing(int size){
        super(size);
    }

    public int hash(Object data){
        int hashValue = data.hashCode();
        int abs = Math.abs(hashValue);
        return abs%a.length;
    }
    public void add(Object data){
        // Guard against null data
        if(data==null) return;  
        int currentIndex = hash(data);
        // While searching for a slot if a collsion occur hash forward, break loop if a empty slot is found
        // or a slot has the DELETED obj.
        while(a[currentIndex]!=null){
          
            // If the data is within the array already break the loop
            if(data.equals(a[currentIndex])) return;
            // If the current index has DELETED obj. stored within store the data instead and return;
            if(a[currentIndex].equals(DELETED)){
                a[currentIndex] = data;
                return;
            }
            // Do double hashing if a collsion occurs (Commented out to avoid error)

            //currentIndex = hash(data + hash2(data)); 

        }
        // Loop has broken due to an empty slot therefore we can add the data to the array
        a[currentIndex] = data;
        

    }
    public int hash2(Object data){
        // This method in the exam said NOT TO IMPLEMENT so we will leave it empty
        return 0;
    }
}
