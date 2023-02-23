import java.util.Random;
public class MergeSort {
    public static void mergeSort( int [] inputArray){
        int arrayLength = inputArray.length;
        if ( arrayLength < 2){
            return;
        }
        int mid = arrayLength /2;
        int [] leftArray = new int [mid];
        int [] rightArray = new int [arrayLength - mid];
        for( int i = 0; i < mid; i++){
            leftArray[i] = inputArray[i];
        }
        for(int i = mid; i < arrayLength; i++){
            rightArray[i - mid] = inputArray[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(inputArray, leftArray, rightArray);
    }
    private static void merge(int [] inputArray, int [] leftArray, int [] rightArray){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;
        while( i < leftSize && j < rightSize){

            if ( leftArray[i] <= rightArray[j]){
                inputArray[k] = leftArray[i];
                i++;
            }
            else
            {
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize){
            inputArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main (String [] args){
        /*Random rnd = new Random();
        int [] elements = new int[5];
        for ( int i = 0; i <= elements.length; i++){
            elements[i] = rnd.nextInt(3000);
        }*/
        int [] elements = {2, 7, 4, 7, 9, 3, 7,10};
        mergeSort(elements);
        System.out.println(java.util.Arrays.toString(elements));
    }

}
