import java.util.Random;
public class Finding_dublicates_two_sortedArray2 {
    public static int [] dublicates(int n, int m){
        Random rnd = new Random();
        int [] array = new int [n];
        int [] array1 = new int[m];
        int nxt = 0;
        int nxt1 = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) +1;
            array[i] = nxt;
        }
        for (int j = 0; j < m ; j++) {
            nxt1 += rnd.nextInt(10) +1;
            array1[j] = nxt1;
        }

      //return array;
        int nextfirst = 0;
        int nextNext = 0;
        int sum = 0;
        while (array.length > nextfirst && array1.length > nextNext){
            //System.out.println(" array är " + java.util.Arrays.toString(array));
            //System.out.println(" array1 är " + java.util.Arrays.toString(array1));

            if(array.length > nextNext){
                nextNext++;
            }
            else if(array1.length > nextfirst){
                nextfirst ++;
            }
            else if(array[nextfirst] == array1[nextNext]){
                nextfirst ++;
                sum++;
            }
        }
        long t1 = System.nanoTime();
        System.out.println("tiden är " + (t1-t0));
     return new int[]{sum};
    }

    public static void main(String [] args){
        int[] result = dublicates(1000000, 1000000);
        System.out.println( "resultaten är " + java.util.Arrays.toString(result));
    }
}
