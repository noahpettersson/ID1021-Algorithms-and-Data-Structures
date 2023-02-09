import com.sun.source.tree.IfTree;

import java.util.Random;

public class ArrayHeap {
    public Integer[] heap;

    final Integer maxsize;
    private Integer index = 0;

    public ArrayHeap(Integer n) {
        this.heap = new Integer[n];
        this.maxsize = n-1;
    }

    public Integer parent(Integer i) {
        if( (i % 2) == 0 ) {
            if((i-2)/2 >= 0)
                return (i-2)/2;
            else return 0;
        } else return (i-1)/2;
    }

    public Integer rightChild(Integer i) {
        return i*2+2;
    }

    public Integer leftChild(Integer i) {
        return i*2+1;
    }

    public void add(Integer value) {
        if(index == maxsize) {
            System.out.println("heap is full");
            return;
        }
        else if(heap[0] == null) {
            heap[0] = value;
            return;
        } else
            heap[++index] = value;

        Integer i = index;
        while(heap[i] < heap[parent(i)] && i >= 0) {
            Integer temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public Integer remove() {
        if(heap[index] == null) {
            System.out.println("Heap is empty");
            return null;
        }
        Integer tbr = heap[0];
        if(index == 0) {
            heap[index] = null;
            return tbr;
        }
        heap[0] = heap[index];
        heap[index] = null;
        index--;
        Integer i = 0;

        while(leftChild(i) < heap.length) {
            if(heap[leftChild(i)] != null){
                if((heap[rightChild(i)] != null) && (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)])) {
                    if(heap[leftChild(i)] < heap[rightChild(i)]) {
                        heap[leftChild(i)] = swap(heap[i], heap[i] = heap[leftChild(i)]);
                        i = leftChild(i);
                    } else {
                        heap[rightChild(i)] = swap(heap[i], heap[i] = heap[rightChild(i)]);
                        i = rightChild(i);
                    }
                } else {
                    if(heap[i] > heap[leftChild(i)]) {
                        heap[leftChild(i)] = swap(heap[i], heap[i] = heap[leftChild(i)]);
                        i = leftChild(i);
                    } else return tbr;
                }
            } else return tbr;
        }
        return tbr;
    }

    public Integer swap(Integer a, Integer b) {
        return a;
    }

    public ArrayHeap arrayGen(Integer n) {
        Random rnd = new Random();
        ArrayHeap array = new ArrayHeap(n);
        for(int i = 0; i < array.heap.length; i++) {
            array.heap[i] = rnd.nextInt(n);
        }
        return array;
    }

    public void print() {
        for(int i = 0; i < heap.length; i++) {
            System.out.println(heap[i]);
        }
    }

}
