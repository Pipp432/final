package Heap;

public class HuffmanNode implements Comparable<HuffmanNode>  {
    Character letter;
    int numberOfOccurence;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode parent;

    public HuffmanNode(int numberOfOccurence){
        this(null,numberOfOccurence,null,null,null);
    }
    public HuffmanNode(char letter,int numberOfOccurence){
        this(letter,numberOfOccurence,null,null,null);

    }
    public HuffmanNode(Character letter,int numberOfOccurence, HuffmanNode left, HuffmanNode right, HuffmanNode parent)
    {
        this.letter = letter;
        this.numberOfOccurence = numberOfOccurence;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public static HuffmanNode createHuffmanTree(ObjectHeap heap) throws Exception{
        if(heap==null) return null;
        if(heap.size()<2) return null;
        
        while(heap.size()>1){
            HuffmanNode first = (HuffmanNode) heap.pop();
            HuffmanNode second = (HuffmanNode) heap.pop();
            HuffmanNode newNode  = new HuffmanNode(null, 
                        first.numberOfOccurence+second.numberOfOccurence, first, 
                        second, null);
            heap.add(newNode);
        }
        return (HuffmanNode) heap.top();

    }
    public static void printHuffmanTree(HuffmanNode root,String s){
        if(root.left ==null && root.right==null && Character.isLetter(root.letter)){
            System.out.println(root.letter+": "+s);
            return;
        }
        printHuffmanTree(root.left, s+"0");
        printHuffmanTree(root.right, s+"1");
        

    }
    public static void main(String args[]) throws Exception{
        HuffmanNode a = new HuffmanNode('a', 10);
        HuffmanNode b = new HuffmanNode('b', 20);
        HuffmanNode c = new HuffmanNode('c', 30);
        HuffmanNode d = new HuffmanNode('d', 15);
        HuffmanNode e = new HuffmanNode('e', 18);
        HuffmanNode f = new HuffmanNode('f', 40);
        ObjectHeap heap = new ObjectHeap();
        heap.add(a);
        heap.add(b);
        heap.add(c);
        heap.add(d);
        heap.add(e);
        heap.add(f);
        createHuffmanTree(heap);
        // System.out.println( ((HuffmanNode)heap.top()).left.right.letter);
        printHuffmanTree((HuffmanNode)heap.top(), "");
    }
    @Override
    public int compareTo(HuffmanNode o) {
       if(o.numberOfOccurence<this.numberOfOccurence) return 1;
       if(o.numberOfOccurence>this.numberOfOccurence) return -1;
        return 0;
    }
    
}
