/*public class search_sorted {
    //since the array is sorted we implement the binary search
    public static boolean Binary(int [] elements, int target){
         int firstElement;
         int  lastElement;
         int  midElement;
        boolean hittad = false;

        while(true){
            midElement = (lastElement + firstElement)/2;
            if(elements[midElement] > target){
                lastElement = midElement-1;
                //target = lastElement;
                //hittad = false;
            }
            if((elements[midElement]) < target) {
                firstElement = midElement + 1;
                break;
            }
        }

        //else if ( firstElement <= lastElement && !hittad)
            return false;


    }

    public static void main (String []args){
        int result = Binary(new int [] {2, 3, 4,5 ,6}, 3);
            System.out.println(result);


    }
}*/