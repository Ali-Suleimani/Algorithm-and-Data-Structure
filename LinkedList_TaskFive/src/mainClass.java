
//import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;

public class mainClass {
    public static void main (String [] args){
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%6s%10s%18s%12s\n", "a", "b", "Linked List", "Array");
        int[][] arr = {{1000, 10_00}, {2000, 20_000}, {3000, 30_000}};

        for (int[] r: arr) {
            LinkedList.bench(r[0], r[1]);
        }


        LinkedList list_a = new LinkedList();
        LinkedList list_b = new LinkedList();

        Random rnd = new Random();
          //int x = rnd.nextInt(20);
        for(int i = 0; i < 100; i++){
            list_a.insert(i);
        }

        for(int i = 0; i < 3; i++){
            list_b.insert(i+1);
        }
/*
        LinkedList list = list_a.createList(3);
        LinkedList list2 = list_a.createList(4);
        list.show();
        System.out.println();
        list2.show();
        System.out.println();
        list.head.append(list2.head);
/*
        list.show();
       // list_a.insert(18);
       // list_a.insert(19);
        //list_a.insert(20);
       // list_a.insertAt(2, 45);
        //list_a.generate(45);

/*
        list_a.show();
        System.out.println();
        list_b.show();

        list_a.head.append(list_b.head);

        System.out.println();

        list_a.show();
*/
        int[] a = {1, 2, 3, 4, 5};
        int[] b=  {6, 7, 8, 9, 10};;
        int[] c =  list_a.appendArray(a, b);
       // System.out.println(Arrays.toString(a));
       // System.out.println(Arrays.toString(b));
       // System.out.println(Arrays.toString(c));
          /*  Random rnd = new Random();
            for (int i = 0; i < 5; i++) {
                int insertRand =  rnd.nextInt(25);
                list_a.add(insertRand);
            }
            System.out.println(list_a); */


    }
}
