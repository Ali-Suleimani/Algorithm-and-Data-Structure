import java.util.Random;
public class binary_search_random_array {
    public static boolean [] binary_search(int n, int key) {
        Random rnd = new Random();
        int [] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++){
            nxt += rnd.nextInt(13) +1;
            array[i] = nxt;
        }
        //System.out.println(" The array is " + java.util.Arrays.toString(array));
        // this array will be used for the binary search array
        int first = 0;
        int last = array.length - 1;

        while (true) {
            int mid =  first +((last - first) / 2);
            //System.out.println(" the mid is " + mid);
            if (array[mid] == key) {
                return new boolean[]{true};
            }
            if ((array[mid] < key) && (mid < last)) {
                first = mid + 1;
                continue;
            }
            if ((array[mid] > key) && (mid > first)) {
                last = mid - 1;
                continue;
            }
            if (array[mid] != key){
                return new boolean[]{false};
            }
            break;
        }
        return new boolean[]{false};
    }

    public static void main (String [] args){
        long n0 = System.nanoTime();
        boolean [] resultat = binary_search( 16000000, 50);
        System.out.println(java.util.Arrays.toString(resultat));
        long n1 = System.nanoTime();
        System.out.println("The execution time is " + (n1-n0) + " nanoseconds");
        //System.out.println(10 + " är elementen finns i array? " + java.util.Arrays.toString(resultat));
    }
}
