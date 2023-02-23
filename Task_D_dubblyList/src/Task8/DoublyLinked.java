package Task8;

import TaskD.DoublyList;

import java.util.Random;

public class DoublyLinked {
    Node head; // head of list

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public void push(int new_data) {
        Node new_Node = new Node(new_data);  //skapar ramen för första noden

        new_Node.next = head;
        new_Node.prev = null;
        if (head != null)
            head.prev = new_Node;
        head = new_Node;
    }

    void deleteNode(Node del) {

        if (head == null || del == null) {
            return;
        }

        if (head == del) {
            head = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }

        return;
    }

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] sequence = new int[loop];
        for (int i = 0; i < loop ; i++) {
            sequence[i] = rnd.nextInt(n);
        }
        return sequence;
    }

    public void pushDouble(int new_data) {   // varför använder vi den
        Node new_item = new Node(new_data);
        new_item.prev = null ;
        new_item.next = head;
        if (head != null) {
            head.prev = new_item;
        }
        head = new_item;
    }


    private static Node[] createArrayOfNodes(DoublyLinked  lst, int n) {
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

    public void pushReference(DoublyLinked.Node reference) {
        reference.prev = null ;
        reference.next = head;
        if (head != null) {
            head.prev = reference;
        }
        head = reference;
    }


    private static void doubleLinkedList(DoublyLinked lst, int []sequence, DoublyLinked.Node[]arr) {
        for ( int a : sequence) {
            lst.deleteNode(arr[a]);
            lst.pushReference(arr[a]);
        }
    }

    public void pushSingle(int item) {
        DoublyLinked.Node oldFirst = head;
        head = new DoublyLinked.Node(item);
        head.next = oldFirst;
    }

    public void pushSingleRef(DoublyLinked.Node item) {
        DoublyLinked.Node oldFirst = head;
        head = item;
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
    private static void singleLinkedList(DoublyLinked lst, int []sequence, DoublyLinked.Node[]arr) {
        for (int a : sequence) {
            lst.deleteSingle(arr[a]);
            lst.pushSingleRef(arr[a]);
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
        DoublyLinked lst = new  DoublyLinked();
        DoublyLinked.Node[] arr = createArrayOfNodes(lst, n);

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
    public void printlist(Node node) {
             Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str ="--------------------------------------";
        int[] sizes = {1000, 1500, 2000, 4000, 6000, 10000};

        for (int n : sizes) {
            time(1000, 10000, n);
            System.out.println(str+str);
        }

    }

    // Driver code
    /*public static void main(String[] args) {

        DoublyLinked dll = new DoublyLinked();

        int[] sequence = keys(20, 10);

       Node[] arr = createArrayOfNodes(dll, 10);

         dll.printlist(dll.head);

        for (Node a : arr) {
            System.out.print(a.data+" ");
        }

    }*/


}
