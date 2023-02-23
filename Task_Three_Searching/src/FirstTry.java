import java.util.Random;
public class FirstTry {
    public static boolean [] search_unsorted(int n, int key) {
        Random number = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += number.nextInt(40) + 1;
            array[i] = nxt;
            //System.out.println(array[i]);
            System.out.println(" the array is " + java.util.Arrays.toString(array));
        }

            for (int index = 0; index < array.length; index++) {
                System.out.println(" här " + array[index]);
                if (array[index] == key) {
                    System.out.println(" är det samma " + array[index]);
                    return new boolean[]{true};
                }
                if (array[index] > key) {
                    System.out.println(" vad här " + array[index]);
                    return new boolean[]{false};
                }
            }
            return new boolean[]{false};

        //return new boolean[]{false};
    }



        public static void main (String[]args){
            long n0 = System.nanoTime();

            boolean[] result = search_unsorted(100, 65);
            System.out.println(java.util.Arrays.toString(result));
            long n1 = System.nanoTime();
            System.out.println(" it takes " + (n1 - n0) + " nanoseconds");
        }


}

