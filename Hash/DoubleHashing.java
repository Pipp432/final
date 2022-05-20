package Hash;

class DoubleHashing extends OpenAddressing{
    private int occupiedSlots = 0;
    private static float MAXFACTOR = 0.75f;
    public Object[] array = new Object[13]; 

    public DoubleHashing(){
    this(DEFAULT_SIZE);
    }

    public DoubleHashing(int size){
    super(size);
    }

    public int hash(Object data){
        
      
        return (int)data%array.length;
    }

    public int hash2(Object data){
       
        return 7-((int)data%7);
    }

    public int find(Object data){
        final int smallNum = 5;
        int h = hash(data);
        int hash2Result = hash2(data);
        for(int i=0; i<currentSize+smallNum; i++){
            if(array[h] == null || array[h].equals(data)) return h;
            h = (h + hash2Result)%array.length;
        }
        return -1;
    }

    public void add(Object data) throws Exception{
        int h = hash(data);
        int hash2Result = hash2(data);
        int emptySlotPosition = -1;
        int i;
        final int smallNum = 5; //a small threshold
        for(i=0; i<currentSize + smallNum; i++){
            // If array at h index is empty or the data is equal to our input break
            if(array[h] == null || array[h].equals(data)) break;

            if(array[h] == DELETED && emptySlotPosition == -1){
                emptySlotPosition = h;
            }
          

            h = (h + hash2Result)%array.length;
        }
        if(i >= currentSize + smallNum){
            rehash();
            add(data);
        }
        else {
            if(array[h] == null){
                if(emptySlotPosition != -1){
                    array[emptySlotPosition] = data;
                } 
                else {
                    array[h] = data;
                    occupiedSlots++;
                }
                currentSize++;
                double currentLoadFactor =
                (double)(occupiedSlots/array.length);

                if(currentLoadFactor > MAXFACTOR) rehash();
            }
        }
    }
    public void rehash() throws Exception{
        Object[] oldArray = array;
        array = new Object[nextPrime(array.length*2)];
        currentSize = 0;
        occupiedSlots = 0;
        for(int i=0; i<oldArray.length; i++){
            if(oldArray[i] != null && oldArray[i]!=DELETED) add(oldArray[i]);
        }
    } 

    public void remove(Object data){
       int index = find(data);
       if(index != -1 && array[index]!=null){
        array[index] = DELETED;
        currentSize--;
       }
    }
                     


    private static boolean isPrime(int n){
         if(n == 2 || n == 3) return true;
         if(n == 1 || n % 2 == 0) return false;
         for(int i = 3; i*i <= n; i+= 2)
            if(n%i == 0) return false;
         return true;
         }
        
    private static int nextPrime(int n){
        if(n % 2 == 0) n++;
        for( ; !isPrime(n); n += 2 ){}
        return n;
    }
}
                        

