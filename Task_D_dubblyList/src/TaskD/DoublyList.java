package TaskD;

import java.util.Random;

public class DoublyList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        public   Node(int val) {
            data = val;
        }
    }

    public void pushReference(Node reference) {
        reference.prev = null ;
        reference.next = head;
        if (head != null) {
            head.prev = reference;
        }
        head = reference;
    }

    public void pushDouble(int new_data) {
        Node new_item = new Node(new_data);
        new_item.prev = null ;
        new_item.next = head;
        if (head != null) {
            head.prev = new_item;
        }
        head = new_item;
    }

    public void pushSingleRef(Node item) {
        Node oldFirst = head;
        head = item;
        head.next = oldFirst;
    }

    public void pushSingle(int item) {
        Node oldFirst = head;
        head = new Node(item);
        head.next = oldFirst;
    }

    public void deleteSingle(Node targetElement) {
        Node prev = null, curr = head;
        if (head == null || targetElement == null) {
            return;
        }
        while (curr != null) {
            if (curr == targetElement) {
                if (curr == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }


    void deleteNode(Node del) {
        if (head == null || del == null) {
            System.out.println("Not  ");
            return;
        }
        if (head == del) {
            head = del.next;
        }

        //System.out.println(" found  " + del.data);
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }
    }

    public void printlist(Node node) {
        Node last = null;

        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();

    }

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] sequence = new int[loop];
        for (int i = 0; i < loop ; i++) {
            sequence[i] = rnd.nextInt(n);
        }
        return sequence;
    }

    private static Node[] createArrayOfNodes(DoublyList lst, int n) {
        for (int i = 0; i < n ; i++) {
            lst.pushDouble(i);
        }

        Node[] arr = new Node[n];
        Node current = lst.head;
        for (int i = 0; current!= null; i++) {
            arr[i] =  current;
            current = current.next;
        }
        return arr;
    }

    private static void singleLinkedList(DoublyList lst, int []sequence, Node[]arr) {
        for (int a : sequence) {
            lst.deleteSingle(arr[a]);
            lst.pushSingleRef(arr[a]);
        }
    }
    private static void doubleLinkedList(DoublyList lst, int []sequence, Node[]arr) {
        for ( int a : sequence) {
            lst.deleteNode(arr[a]);
            lst.pushReference(arr[a]);
        }

    }

    private static void printTime(double []measure, int loop, int n, String str) {
        int tries = measure.length;
        double min = Double.POSITIVE_INFINITY;
        double max = 0;
        double sum = 0;
        for (int i = 0; i < tries; i++) {
            double t = measure[i];
            if ( t < min )
                min = t;
            if ( t > max )
                max = t;
            sum += t;
        }
        String s = "  n: %4d \tmin: %.2fns\t avg: %.2fns\t max: %.2fns\n" ;
        System.out.printf(str + s ,n ,(min/loop), (sum/(tries*loop)), (max/loop));
    }

    private static void time(int tries, int loop, int n) {
        int[] sequence = keys(loop, n);
        DoublyList lst = new  DoublyList();
        Node[] arr = createArrayOfNodes(lst, n);

        double[] measurements = new double[tries];

        for (int i = 0; i < tries; i++) {
            double n0 = System.nanoTime();
            doubleLinkedList(lst, sequence, arr);
            double n1 = System.nanoTime();
            measurements[i] = (n1 - n0);
        }
        printTime(measurements, loop, n, "Double Linked List");

        for (int i = 0; i < tries; i++) {
            double n0 = System.nanoTime();
            singleLinkedList(lst, sequence, arr);
            double n1 = System.nanoTime();
            measurements[i] = (n1 - n0);
        }
        printTime(measurements, loop, n, "Single Linked List");

    }

    public static void main(String[] args) {
        String str ="--------------------------------------";
        int[] sizes = {1000, 1500, 2000, 3000, 4000, 5000, 6000, 7000, 8000};

        for (int n : sizes) {
            time(1000, 10000, n);
            System.out.println(str+str);
        }

    }
}

/*
   DoublyList lst = new  DoublyList();

        lst.pushSingle(4);
        lst.pushSingle(3);
        lst.pushSingle(2);
        lst.pushSingle(1);

        lst.push(4);
        lst.push(3);
        lst.push(2);
        lst.push(1);


        lst.deleteNode(lst.head.next.next);

        lst.printlist(lst.head);
 */


/*
         lst.push(4);
         lst.push(3);
         lst.push(2);
         lst.push(1);
         lst.printlist(lst.head);
         lst.deleteNode(lst.head);
         lst.printlist(lst.head);
         lst.deleteNode(lst.head);
         lst.printlist(lst.head);
*/
