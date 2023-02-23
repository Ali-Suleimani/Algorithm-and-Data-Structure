import java.util.Random;
public class Finding_Dublicates_InTwo_Sorted_Array {
    public static boolean [] dublicates_sorted (int n, int m){
        Random rnd = new Random();
        int [] array = new int[n];
        int [] array1 = new int[m];
        int nxt = 0;
        int nxt1 = 0;

        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) +1;
            array[i] = nxt;
        }
        for (int j = 0; j < m ; j++) {
            nxt1 += rnd.nextInt(10) +1;
            array1[j] = nxt1;
        }

        int first = 0;
        int last = array.length - 1;
        int first1 = 0;
        int last1 = array1.length -1;

        System.out.println(java.util.Arrays.toString(array));
        System.out.println(java.util.Arrays.toString(array1));

        while (true) {
            int mid =  first +((last - first) / 2);
            int mid1 = first1 + ((last1-first1)/2);
            //System.out.println(" the m is " + array[m]);
            //System.out.println(" this is " + array[mid]);

            if (array[mid] == array1[mid1]) {
                System.out.println("the arra " + array[mid]);
                System.out.println(" the m is " + m);
                return new boolean[]{true};
            }
            if ((array[mid] < array1[mid1]) && (mid < last)) {
                first = mid + 1;
                continue;
            }
            if ((array[mid] > array1[mid1]) && (mid > first)) {
                //System.out.println("Prolog1");
                last = mid - 1;
                continue;
            }
            if (array[mid] != array[mid1]){
                //System.out.println("Prolog2");
                return new boolean[]{false};
            }
            break;
        }
        return new boolean[]{false};
    }

    public static void main (String [] args){
        boolean [] result = dublicates_sorted(20, 20);
        System.out.println(java.util.Arrays.toString(result));
    }


}



