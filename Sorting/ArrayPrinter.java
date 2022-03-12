package Sorting;

public class ArrayPrinter {
    public void printArray(int arr[])
    {
        int n = arr.length;
        String result = "[";
        for (int i=0; i<n; ++i)
            if(i<n-1){
                result+=" "+arr[i] + ",";
            }else{
                result+=" "+arr[i] +" ";
            }
           
        result+="]";
        System.out.println(result);

    }
}
