public class binary_search {
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        System.out.println(java.util.Arrays.toString(array));

        while (true) {
            int mid = first + ((last - first) / 2);
            System.out.println(" the mid is " + mid);
            if (array[mid] == key) {
                return true;
            }
            if ((array[mid] < key) && (mid < last)) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                System.out.println("Prolog");
                first = mid + 1;
                continue;
            }
            if ((array[mid] > key) && (mid > first)) {
                System.out.println("array1 is " + array[mid]);
                last = mid - 1;
                continue;
            }
            if (array[mid] != key){
                System.out.println(" array2 is " + array[mid]);
                return false;
            }
            break;
            }
            return false;
        }

    public static void main (String [] args){

        boolean resultat = binary_search( new int [] {2, 4, 10, 7, 8, 9}, 1);
        System.out.println(resultat);
    }
}
