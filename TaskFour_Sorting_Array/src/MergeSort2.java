import java.util.Random;
public class MergeSort2 {
    public static void sort(int[] org) {
        int [] a = org;
        if (a.length == 0)
            return;
        int[] aux = new int[a.length];
        sort(org, aux, 0, a.length -1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi-lo)/2;

            sort(org, aux, lo, mid);
            sort(org, aux, mid+1, hi);

            merge(org, aux, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
    // copy all items from lo to hi from org to aux
        for ( int k = lo; k <= hi; k++) {
          aux[k] = org[k];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
           // for all indeces from lo to hi
        for ( int k = lo; k <= hi; k++) {
         // if i is greater than mid, move the j item to the org array, update j
            if(i > mid){
                org[k] = aux[j];
                j++;
            }

         // else if j is greate than hi, move the i item to the org array, update i
            else if( j > hi){

                org[k] = aux[i];
                i++;
            }

            // else if the i item is smaller than the j item,
            // move it to the org array, update i
            else if (aux[i] < aux[j]){
                org[k] = aux[i];
                i++;
            }

          // else you can move the j item to the org array, update j
            else {
                org[k] = aux[j];
                j++;
            }

        }
    }

    public static void main(String [] args){
        //int [] elements = { 5, 2, 7, 975, 8, 3, 45, 23, 4, 0, 3};
        Random rnd = new Random();
        int [] elements = new int [4960];
        for ( int i =1; i < elements.length; i++){
            elements[i] = rnd.nextInt(20);
        }
        long t0 = System.nanoTime();
        sort(elements);
        System.out.println(java.util.Arrays.toString(elements));
        long t1 = System.nanoTime();
        System.out.println("tiden är " + (t1-t0));

    }

}
