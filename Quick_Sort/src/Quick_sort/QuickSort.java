
package Quick_sort;
import java.util.Random;

public class QuickSort {
    public static void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int result;
            result = partition(array, lowIndex, highIndex);
            sort(array, 0, result - 1);
            sort(array, result+1, highIndex);
        }
        System.out.println(java.util.Arrays.toString(array));
    }

    private static int partition(int[] inputarray, int lowerBound, int higherBound) {

        int pivot = inputarray[lowerBound];
        int pointerStart = lowerBound;
        int pointerEnd = higherBound-1;
        while (pointerStart < pointerEnd) {
            while (inputarray[pointerStart] <= pivot && pointerStart < higherBound) {
                pointerStart++;
            }
            while (inputarray[pointerEnd] > pivot && pointerEnd > lowerBound) {
                pointerEnd--;
            }
            if (pointerStart < pointerEnd) {   // if start cross end
                int swap = inputarray[pointerStart];
                inputarray[pointerStart] = inputarray[pointerEnd];
                inputarray[pointerEnd] = swap;
            }
        }
        int swap = inputarray[pointerStart];
        inputarray[pointerStart] = inputarray[pointerEnd];
        inputarray[pointerEnd] = swap;
        return pointerEnd;
        //return swap;

    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int [] elements = new int[10];
        for (int i = 0; i < elements.length; i++){
            elements[i] = rnd.nextInt(5);
            sort(elements, 0, 9);
            System.out.println(java.util.Arrays.toString(elements));
        }
        //System.out.println(java.util.Arrays.toString(elements));


       /* int [] element ={0, 35, 45, 35, 5, 7};
        sort(element, 0, 5);
        System.out.println(java.util.Arrays.toString(element)); */
    }
}


      /*  Random rnd = new Random();
        int[] elements = new int[477];
        for (int i = 0; i <= elements.length; i++) {
        elements[i] = rnd.nextInt(3000);
        sort(elements, 0, 476);

        System.out.println(java.util.Arrays.toString(elements)); */