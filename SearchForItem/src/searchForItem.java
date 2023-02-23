import java.util.Random;
public class searchForItem {
    public static void main(String []args){
        int m = 1000;
        int n = 900;
        int k = 20;
        int[] keys = new int[m];
// fill the keys array with random number from 0 to 10*n

        int[] array = new int[n];
// fill the array with with random number from 0 to 10*n
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
        }
        long t_access = (System.nanoTime() - t0);
        System.out.println(java.util.Arrays.toString(keys));
        System.out.println("the measure time is " + (System.nanoTime() - t0) + " nanoseconds" );
    }

}
