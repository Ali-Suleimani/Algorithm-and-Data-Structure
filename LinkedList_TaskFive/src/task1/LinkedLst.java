package task1;



import java.util.NoSuchElementException;

public class LinkedLst {
    int data;
    LinkedLst head;
    LinkedLst next;

    LinkedLst(int d) {
        data = d;
        next = null;
    }
    LinkedLst() {}

    public void append(LinkedLst b) {
        LinkedLst nxt = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
    }
    public static void insert(LinkedLst list, int data) {
        LinkedLst new_node = new LinkedLst(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            LinkedLst last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

    }
    public int pop() {
        if (head == null) throw new NoSuchElementException("Stack underflow");
        int data = head.data;  // save item to return
        head =  head.next;    // delete first node
        return data;   // return the saved item
    }

    public void push(int data) {
        LinkedLst new_node = new LinkedLst(data);
        new_node.next = null;
        if (this.head == null) {
            head = new_node;
        }
        else {
            LinkedLst oldFirst = head;
            head = new_node;
            head.next = oldFirst;
        }
    }
    public static int[] appendArray(int[] a, int[] b) {
        int n = a.length + b.length;
        int j = 0;
        int [] array = new int[n];
        for(int i= 0; i < n; i++) {
            if(i < a.length)
                array[i] = a[i];
            else {
                array[i] = b[j++];
            }
        }
        return array;
    }
    public static LinkedLst createList(int n) {
        LinkedLst list = new LinkedLst();
        for(int i= n; 0 < i; i--) {
            list.push(i);
        }
        return list;
    }

    public static int[] createArray(int n) {
        int [] array = new int[n];
        for(int i= 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static void printList(LinkedLst list) {
        LinkedLst curr = list.head;
        System.out.print("LinkedList: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public static void bench(int a, int b) {
        System.out.printf("%10d%10d", a, b);
        int tries = 1000;
        double sum = 0;

        for(int i= 0; i < tries; i++) {
            LinkedLst list_a = createList(a);
            LinkedLst list_b = createList(b);
            long start = System.nanoTime();
            list_a.head.append(list_b.head);
            long end = System.nanoTime();
            double t = (end - start);
            sum += t;
        }
        System.out.printf("%12.0f", (sum/(tries*1000)));

        sum = 0;
        for(int i= 0; i < tries; i++) {
            int[] arr_a = createArray(a);
            int[] arr_b = createArray(b);
            long start = System.nanoTime();
            appendArray(arr_a , arr_b);
            long end = System.nanoTime();
            double t = (end - start);
            sum += t;
        }
        System.out.printf("%14.0f\n",(sum/(tries*1000)));

    }


    public static void main(String[] args) {
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%6s%10s%18s%12s\n", "a", "b", "Linked List", "Array");
        int[][] arr = {{100, 100}, {1000, 1000}, {10000, 10000},{100000, 100000}, {1000000, 1000000}};

        for (int[] r: arr) {
            bench(r[0], r[1]);
        }
    }
}

/*
    int n = 20;
    LinkedLst list_a = createList(5);
    LinkedLst list_b = createList(3);

    printList(list_a);
    printList(list_b);

    LinkedLst a = list_a.head;
    LinkedLst b = list_b.head;

        a.append(b);
                printList(list_a);

                int[] arr_a = createArray(5);
                int[] arr_b = createArray(3);

                System.out.println( Arrays.toString(arr_a) );
                System.out.println( Arrays.toString(arr_b) );
                System.out.println( Arrays.toString( appendArray(arr_a, arr_b) ) );
//System.out.println(Arrays.toString(createArray(n)));

 */


/*

   LinkedLst list_a = new LinkedLst();
        LinkedLst list_b = new LinkedLst();

      //  for(int i= 10; 0 < i; i--) { list_a.push(i); } printList(list_a);

        for(int i= 0; i < 10; i++) {
            insert(list_a, i+1);
        }
        printList(list_a);

        for(int i= 10; i < 20; i++) {
            insert(list_b, i+1);
        }
         printList(list_b);

        LinkedLst a = list_a.head;
        LinkedLst b = list_b.head;
        a.append(b);
        printList(list_a);
 */












/*
            LinkedLst list_a = new LinkedLst();

                insert(list_a, 1);
                insert(list_a, 2);
                insert(list_a, 3);
                insert(list_a, 4);
                insert(list_a, 5);
                insert(list_a, 6);
                insert(list_a, 7);
                insert(list_a, 8);

               printList(list_a);

             LinkedLst list_b = new LinkedLst();

              insert(list_b, 9);
              insert(list_b, 10);
              insert(list_b, 11);
              insert(list_b, 12);

             printList(list_b);

            LinkedLst a = list_a.head;
            LinkedLst b = list_b.head;

             a.append(b);

           printList(list_a);
*/