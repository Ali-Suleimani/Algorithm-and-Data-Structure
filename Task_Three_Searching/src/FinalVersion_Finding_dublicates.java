public class FinalVersion_Finding_dublicates {
    public static int dublicate(int [] array, int [] array1){
        int firstNext = 0;
        int nextNext = 0;
        int sum = 0;

        long t0 = System.nanoTime();
        while( array.length-1 > firstNext && array1.length-1 > nextNext){
            if (array.length > nextNext){
                nextNext ++;
            }
            if (array1.length-1 > firstNext){
                firstNext ++;
            }
            if (array[firstNext] == array1[nextNext]){
                firstNext ++;
                sum ++;
            }
        }
        long t1 = System.nanoTime();
        System.out.println( " tiden är " + (t1-t0) + " nanosekund");
        return sum;
    }

    public static void main (String [] args){
        //long t0 = System.nanoTime()
        int result = dublicate(new int[]{3, 5, 6, 7, 8}, new int []{3, 8, 10, 11, 12});
        //long t1 = System.nanoTime();
        System.out.println(" resultatet är " + result);


    }
}
