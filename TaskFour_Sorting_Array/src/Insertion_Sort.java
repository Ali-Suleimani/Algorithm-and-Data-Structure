import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Insertion_Sort {
    public static void insertionSort(int [] array){
        long t0 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            // for each element from i towards 1, swap the item found with the
            // item before it if it is smaller
            int current = array[i];
            int j = i-1;
            for (;(j >= 0 && array[j] > current); j--) {
                array[j +1] = array[j];
            }
            array[j+1] = current;
        }
        long t1 = System.nanoTime();
        System.out.println("tiden är " + (t1-t0));
    }

    public static void main (String [] args){
        //int [] elements = { 2, 5, 6, 40, 3, 35, 2, 11};

        Random rnd = new Random();
        int [] elements = new int [4960];
        for (int i = 0; i < elements.length; i++){
            elements[i] = rnd.nextInt(20);
        }
        System.out.println("the array is " + java.util.Arrays.toString(elements));
        //long t0 = System.nanoTime();
        insertionSort(elements);
        System.out.println(" the sorted array is " + java.util.Arrays.toString(elements));
        //long t1 = System.nanoTime();
        //System.out.println("exekveringstiden är " + (t1-t0));
    }
}
