package com.company;
import java.util.Random;
public class TaskFour_Sorting_Array{
    public static void sort(int [] array){
        long t0 = System.nanoTime();
        for(int i = 0; i < array.length -1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length ; j++) {
                // If the element at position j is smaller than the value
                // at the candidate position - then you have a new candidate
                // posistion.
                if(array[j] < array[cand]){
                    cand = j;
                }
            }
            // Swap the item at position i with the item at the candidate position.
            int map = array[i];
            array[i] = array[cand];
            array[cand] = map;
        }
        long t1 = System.nanoTime();
        System.out.println("the time in nanosecond is " + (t1-t0));
    }
    public static void main(String [] args){
        Random rnd = new Random();
        int [] elements = new int [1240];
        for (int i = 0; i < elements.length; i++){
            elements[i] = rnd.nextInt(20);
        }
        //int [] elements = {5, 3, 5, 9,0,3};

        System.out.println("the array is " + java.util.Arrays.toString(elements));
        sort(elements);
        System.out.println(" the sorted array is " + java.util.Arrays.toString(elements));

    }
}

