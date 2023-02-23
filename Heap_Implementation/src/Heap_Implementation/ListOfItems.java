package Heap_Implementation;
import java.util.NoSuchElementException;
import java.util.Random;

public class ListOfItems {

        public Node headUnsorted;
        public  Node headSorted;

        // create a constructor
        class Node{
                Integer item;
                Node next;
                Node(Integer n){
                        item = n;
                }
        }
        //##############  beginning of unsorted  list ##################
        public boolean isEmptyUnsorted() {
                return headUnsorted == null;
        }
        public void addUnsorted(Integer item) {
                Node oldFirst = headUnsorted;
                headUnsorted = new Node(item);
                headUnsorted.next = oldFirst;
        }

        //        remove unsorted O(n)
        public Integer removeUnsorted() {
                if (isEmptyUnsorted()) throw new NoSuchElementException("queue underflow");
                Node first = headUnsorted;
                Node prev = first;
                Node prevMin = null;
                int min = first.item;

                while (first!=null){
                        if(min > first.item) {
                                min = first.item;
                                prevMin = prev;
                        }
                        prev = first;
                        first = first.next;
                }

                if (prevMin==null){
                        headUnsorted = headUnsorted.next;
                }

                if (prevMin!=null)
                        prevMin.next = prevMin.next.next ;
                return min;
        }

        public boolean isEmptySorted() {
                return headSorted == null;
        }

        // add sorted O(n)
        public void addSorted(Integer item) {
                Node first = headSorted;
                if (!isEmptySorted()) {
                        if (first.item > item) {
                                headSorted = new Node(item);
                                headSorted.next = first;
                        } else {
                                Node prev = first;
                                while (first!=null) {
                                        if (first.item >= item) {break;}
                                        prev = first;
                                        first = first.next;
                                }
                                Node prevNext = prev.next;
                                prev.next = new Node(item);
                                prev.next.next = prevNext;
                        }
                }
                else {
                        headSorted = new Node(item);
                }
        }
        // remove sorted O(1)
        public Integer removeSorted() {
                if (isEmptySorted()) throw new NoSuchElementException("queue underflow");
                Integer item = headSorted.item;
                headSorted = headSorted.next;
                return item;
        }
        //####################### end ######################

        public static void print(Node x) {
                Node first = x;
                while (first!=null) {
                        System.out.print (first.item +"  ");
                        first = first.next;
                }
                System.out.println();
        }

        private static int[] keys(int n) {
                Random rnd = new Random();
                int[] sequence = new int[n];
                for (int i = 0; i < n; i++) {
                        sequence[i] = rnd.nextInt(n);
                }
                return sequence;
        }

        public static void bench(int tries,  int n) {
                int m = n*tries;
                System.out.printf("%12d", n);

                double sum  = 0;
                double sum2 = 0;
                double sum3 = 0;
                double sum4 = 0;

                for(int i= 0; i < tries; i++) {
                        ListOfItems list = new ListOfItems();
                        int[] sequence = keys(n);

                        long start = System.nanoTime();
                        for(int e: sequence){
                                list.addUnsorted(e);
                        }
                        long end = System.nanoTime();
                        double t = (end - start);
                        sum += t;

                        start = System.nanoTime();
                        for(int j= 0; j < sequence.length; j++){
                                list.removeUnsorted();
                        }
                        end = System.nanoTime();
                        t = (end - start);
                        sum2 += t;


                        start = System.nanoTime();
                        for(int c: sequence){
                                list.addSorted(c);
                        }
                        end = System.nanoTime();
                        t = (end - start);
                        sum3 += t;

                        start = System.nanoTime();
                        for(int k= 0; k < sequence.length; k++){
                                list.removeSorted();
                        }
                        end = System.nanoTime();
                        t = (end - start);
                        sum4 += t;
                }

                System.out.printf("%16.0f",(sum/(m)));
                System.out.printf("%18.0f",(sum2/(m)));
                System.out.printf("%16.0f",(sum3/(m)));
                System.out.printf("%18.0f\n",(sum4/(m)));
        }


        public static void main(String[] args) {
                System.out.printf("#%10s%18s%18s%18s%18s\n",
                        "n", "add unsorted", "remove unsorted",
                        "add sorted", "remove sorted");

                int[] sizes = {1000, 2000, 3000,  4000, 5000, 6000, 7000, 8000};

                for (int n: sizes) {
                        bench(1000, n);
                }

        }

}


    /*public class Node{
        private Integer item;
        private Node next;

        public Node (Integer item){
            this.item = item;
        }
    }

    public void add(Integer item){
        Node node = new Node(item);
        if (root == null){
            root = node;
            last = node;
        }else{
            root.next = node;
            last = node;
        }
        size ++;
    }

    public void show(){
        Node node = root;
        while(root != null){
           System.out.println(node.item);
            node = node.next;
        }
    }

    public static void main (String [] args){
        ListOfItems list = new ListOfItems();
        list.add(67);
        list.add(9);
        list.add(89);
        list.show();
    }*/




        /*private void display(Integer item){
            System.out.println( " ".repeat(item) + this.priority + "(" + this.size + ")");
            if(this.leftChild == null && this.rightChild == null)
                return;
            if(this.leftChild != null)
                this.leftChild.display(item+2);
            else System.out.println(" ".repeat(item+2) + "...");
        }*/








    /*private Node head;
    private Node last;
    private int size;
    private Node leftChild;
    private Node rightChild;

    private class Node(Integer item){

        private Integer item;
        public Node next;
        public Node(Integer item){
            this.item = item;
        }
    }

    public void add(Integer item){
        Node node = new Node(item);
        if(head == null){
            head = node;
            last = node;
        }else{

            last.next = node;
            last = node;
        }
        size ++;
    }

    public void show(){
        Node node = head;
        while(node!=null){
            System.out.println(node.item);
            node = node.next;
        }
    }

    public static void main(String [] args){
        ListOfItems result = new ListOfItems();
        result.add(34);
        result.add(33);
        result.add(21);
        result.show();


    }*/


