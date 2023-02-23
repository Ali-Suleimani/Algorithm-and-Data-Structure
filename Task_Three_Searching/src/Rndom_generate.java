import java.util.Random;
public class Rndom_generate {
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt = rnd.nextInt(20) +1;
            array[i] = nxt;
            System.out.println(array[i]);
        }
        return array;
    }
    public static void main (String [] args){
        int [] result = sorted(100);
        System.out.println(java.util.Arrays.toString(result));
    }

}
