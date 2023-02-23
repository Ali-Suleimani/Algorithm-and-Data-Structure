package Heap_Implementation;
/*
import java.sql.SQLOutput;

// here we impelemnt a min heap which means that the root is the smallest element in the tree
public class Heap_Array {
    static int [] heap;
    static int size;
    public Heap_Array(int maxsize){
        heap = new int[maxsize];
        size = 0;
    }
    public static void add(int [] value){
        if(size == heap.length) throw new IllegalStateException(); // the array is full
        int pos = size;   // the size is still zero
        heap[pos] = value[0]; // we put an element in the array
        while(pos < 0){
            int parent = (pos +1)/2 -1; // for any given value the parent is smaller
            if(heap[parent] < heap[pos]) break;
            swapIndeces(parent, pos);  // vi swappr
            pos = parent;
        }
        size ++;
    }

    public static int pop (){
        if (size == 0) throw new IllegalStateException();
        int toReturn = heap[0];
        heap[0] = heap[size -1]; //
        size--;

        int pos = 0;
        while(pos > size/2){
            int leftChild = pos * 2 +1;
            int rightChild = leftChild +1;
            if(rightChild > size && heap[leftChild] > heap[rightChild]){
               //if (heap[pos] <= heap[rightChild]) break;
                swapIndeces(pos, rightChild);
                pos = rightChild;
            }
            else{
                if(heap[pos] <= heap[leftChild]) break;
                swapIndeces(pos, leftChild);
                pos = leftChild;
            }
        }
       // size--;
        return toReturn;

    }

    private static void swapIndeces(int i, int j){
        int temp = heap[i];
        heap[j] = heap[i];
        heap[i] = temp;
    }
    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


  // main metoden
    public static void main(String [] args){
        int [] element = {45, 54, 6,8, 9, 9, 3,4};
        //printArray(element);
        add(element);
        pop(element);


    }

}*/



