import task1.LinkedLst;

import java.util.Random;
public class LinkedList {
        //int head;
        LinkedList tail;
        Node head;
    /*public LinkedList(Node item, LinkedList list) {
        head = item;
        tail = list;
    }

        public Node head() {
            return this.head;
        }*/

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        if (this.head == null) {
            head = new_node;
        }
        else {
            Node oldFirst = head;
            head = new_node;
            head.next = oldFirst;
         }
        }

    public void insert(int data){
    Node node = new Node(data);
    //node.data = data;   //creating the first node
    node.next = null;
        if(head == null){
            head = node;
        }
        else{
            Node n = head; // initialize a new node in the list
            while(n.next !=null){       //go through the list as long as it is not null
                n = n.next;             // jump to the next node
            }
            n.next = node;               // initialize the null node
        }
    }

    public static int[] appendArray(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] new_array = new int[n];
      int j = 0;
        for (int i = 0; i < n; i++) {
            if(i<a.length){
            new_array[i] = a[i];
            }
            else {
                new_array[i] = b[j++];
            }
        }
        return new_array;
    }
    public void show(){
        Node node = head;                // start from the head
        while(node!=null){           //go through the list
            System.out.print(node.data+ " "); // print them out
            node = node.next;              //move to the next node
        }
      //  System.out.print(node.data + " ");    //to print out the null node
    }

    public static LinkedList createList(int n) {
        LinkedList list = new LinkedList();
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

    public static void bench(int a, int b) {
        System.out.printf("%10d%10d", a, b);
        int tries = 1000;
        double sum = 0;
        for(int i= 0; i < tries; i++) {
            LinkedList list_a = createList(a);
            LinkedList list_b = createList(b);
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


   public void generate(int data){
        Random rnd = new Random();
        int insertData = 0;
        for(int i = 0; i < data; i++){
            insertData = rnd.nextInt(43);
        }
        System.out.println(insertData);
    }


    public static void main (String [] args) {
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%6s%10s%18s%12s\n", "a", "b", "Linked List", "Array");
        int[][] arr = {
                {100, 100},
                {1000, 1000},
                {10000, 10000},
                {100000, 100000},
                {1000000, 1000000}


        };

        for (int[] r : arr) {
            bench(r[0], r[1]);
        }

/*
        LinkedList list_a = createList(5);
        LinkedList list_b = createList(16);
        list_a.show();
        System.out.println();
        list_b.show();

        System.out.println();
        list_a.head.append(list_b.head);
        list_a.show();
   */
    }








         //the rest of the methods are importatnt but not necessary for this assignment

       /* public void insertAtStart(int data){
            Node node = new Node();
            node.data = data;
            node.next = null;
            head = node;
        }

        public void insertAt(int index, int data){   // insert an element at a specific location
            Node node = new Node();
            node.data = data;
            node.next = null;

            if(index == 0){
                insertAtStart(data);
            }
            else {
                Node n = head;                     //start from the head
                for (int i = 0; i < index - 1; i++) {  //go through untill the index before
                    n = n.next;                     //
                }
                node.next = n.next;                    //uppdate the adress
                n.next = node;                       //the insert element point to the next element
            }
        }

        public void deleteAt(int index){
            if(index==0){
                head = head.next;
            }
            else{
                Node n = head;
                Node n1 = null;
                for(int i =0; i<index-1; i++){
                    n = n.next;
                }
                n1 = n.next;
                n.next = n1.next;
                System.out.println("The delete n1 is " + n1.data);
            }
        }*/
        /*public void show(){
            Node node = head;                // start from the head
            while(node.next!=null){           //go through the list
                System.out.println(node.data); // print them out
                node = node.next;              //move to the next node
            }
            System.out.println(node.data);    //to print out the null node
        }*/

       /* public LinkedList(int item, LinkedList list) {
            head = item;
            tail = list;
        }

        public int head() {
            return this.head;
        }

        public LinkedList tail() {
            return this.tail;
        }

        public void append(LinkedList b) {
            LinkedList nxt = this;
            while (nxt.tail != null) {
                nxt = nxt.tail;
            }
            nxt.tail = b;
        }*/


    }


