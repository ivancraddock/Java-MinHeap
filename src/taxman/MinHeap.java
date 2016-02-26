package taxman;




public class MinHeap {
    private HeapNode[] Heap;
    private int maxsize;
    private int size;

    public MinHeap(int max) {
    maxsize = max;
    Heap = new HeapNode[maxsize];
    size = 0 ;
    Heap[0] = new HeapNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
   
    }

    private int leftchild(int pos) {
    return 2*pos;
    }
   
    private int rightchild(int pos) {
    return 2*pos + 1;
    }

    private int parent(int pos) {
    return  pos / 2;
    }
   
    private boolean isleaf(int pos) {
    return ((pos > size/2) && (pos <= size));
    }

    private void swap(int pos1, int pos2) {
        HeapNode tmp = new HeapNode(Heap[pos1].getId(),Heap[pos1].getIncome());
        Heap[pos1] = new HeapNode(Heap[pos2].getId(),Heap[pos2].getIncome());
        Heap[pos2] = tmp;
    }

    public void insert(HeapNode elem) {
    size++;
    Heap[size] = elem;
    int current = size;
   
        while (Heap[current].getIncome() < Heap[parent(current)].getIncome()) {
            swap(current, parent(current));
            current = parent(current);
        }   
    }

    public int getMin(){
        return Heap[1].getIncome();       
    }
   
    public void print() {
    int i;
    for (i=1; i<=size;i++)
        System.out.print(Heap[i] + "\n");
    System.out.println();
    }

    public int removemin() {
    swap(1,size);
    size--;
    if (size != 0)
        pushdown(1);
    return Heap[size+1].getIncome();
    }

    private void pushdown(int position) {
    int smallestchild;
    while (!isleaf(position)) {
        smallestchild = leftchild(position);
        if ((smallestchild < size) && (Heap[smallestchild].getIncome() > Heap[smallestchild+1].getIncome()))
        smallestchild = smallestchild + 1;
        if (Heap[position].getIncome() <= Heap[smallestchild].getIncome()) return;
        swap(position,smallestchild);
        position = smallestchild;
    }
    }

}




