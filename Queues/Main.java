package Queues;

class Main{
    public static void main(String args[] ) throws Exception{
        QueueArray q1 = new QueueArray();
        QueueArray q2 = new QueueArray();
        
        
         
        q1.insertLast(7); 
        q1.insertLast(10);
        q1.insertLast(5);
        q1.insertLast(1);
        q1.insertLast(3); 
        q1.insertLast(8);
        // QueueArray q3 = new QueueArray();
        
        // int originalSize = q1.size();
        // while(originalSize!=q3.size()){
        //     q3.insertLast(q1.front());
        //     q1.insertLast(q1.removeFirst());
        // }
        // q2 = q1;
        
        q1.selectionSort();
        //QueueArray q2 = new QueueArray();
        // q2.insertLast(1);
        // q2.insertLast(3); 
        // q2.insertLast(5); 
        // q2.insertLast(7); 
        // q2.insertLast(9);
        // int k = 0;

        // System.out.println("=================== Queue1 Index ======================");
        while(!q1.isEmpty()){
            System.out.println(q1.removeFirst());
            
        }
        // k=0;
        // System.out.println("=================== Queue2 Index ======================");
        // while(!q2.isEmpty()){
        //     System.out.println("Index: "+k +" value: "+q2.removeFirst());
        //     k++;
        // }
        // System.out.println("=================== Queue3 Index ======================");
        // while(!q3.isEmpty()){
        //     System.out.println("Index: "+k +" value: "+q3.removeFirst());
        //     k++;
        // }
        // k=0;

        // System.out.println("=================== Stack Index ======================");
        // while(!q2.s1.isEmpty()){
        //     System.out.println("Index: "+k +" value: "+q2.s1.top());
        //     q2.s1.pop();

        // }
        
        
        // q2.insertLast(2);
        // q2.insertLast(10);
        // q2.insertLast(42);
        // q2.insertLast(63);
        // I am using queueArray to print out the whole using an overrided toString method
        // QueueArray resultArray= (QueueArray) TestQueue.combine(q1, q2);
        // System.out.println(resultArray.toString());
        // QueueStack qs = new QueueStack();
        // qs.insertLast(2);
        // qs.insertLast(3);
        // qs.insertLast(4);
        // qs.insertLast(5);
        // System.out.println("size: "+qs.size());
        // System.out.println("front: "+qs.front());
        // System.out.println("back: "+qs.back());
        // int i =0;
        // while(!qs.isEmpty()){
        //     System.out.println("index " + i+++": " +qs.removeFirst());
        // }
    }
}