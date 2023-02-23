
package Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

public class Queue1 implements Iterable<Integer> {
    private Node head;
    private Node last;
    private int size;
    private Node left;
    private Node right;

    public class Node {
        private Integer item;
        public Node tail;
        public Node next;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
        public TreeUsingQueue refer(){
            TreeUsingQueue current = new TreeUsingQueue();
            breadthFirst(current);
            return current;
        }

        public void breadthFirst(TreeUsingQueue current){
            if(head == this){
                current.insert(head.item);
            }
            if(left != null){
                current.insert(left.item);
            }
            if(right != null){
                current.insert(right.item);
            }
            if(left != null){
                left.breadthFirst(current);
            }
            if(right != null){
                right.breadthFirst(current);
            }

        }

    }

    public Queue1() {
        this.head = null;
        this.last = null;
    }

    public void add(Integer item) {
        Node node = new Node(item, null);
        //System.out.println("The elelment is " + item);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Integer remove(){
        if (head == null){
            System.out.println("listan är tomt");
            System.exit(-1); // this method exits current program by determining running java virtual machine
        }
        Integer item = head.item;
        head = head.next;
        size --;
        return item;

    }

    // Change the structure of the Queue that is holds a pointer to the first and last element. By using pointer
    // By using pointer we can add a new element in the list instead of traversing.

    public void show(){
       Node node = head;                // start from the head
        while(node!=null){           //go through the list
            System.out.println(node.item+ " "); // print them out
            node = node.next;              //move to the next node
        }
        //  System.out.print(node.data + " ");    //to print out the null node
    }

    public Iterator<Integer> iterator(){
        return new LinkedIterator();
    }
    public TreeUsingQueue getStack(){
        return head.refer();
    }
    private class LinkedIterator implements Iterator<Integer>{
        private Node current;
        private TreeUsingQueue result;

        public LinkedIterator(){
            result = getStack();
        }

        public boolean hasNext() {
            return current !=null;}
        public void remove (){
            throw new UnsupportedOperationException();}

        public Integer next(){
            if(!hasNext()) throw new NoSuchElementException();
            Integer item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main (String [] args) {
        Queue1 result = new Queue1();
        result.add(5);
        result.add(2);         //       5
        result.add(7);      //      2       7
        result.add(1);    //      1   3   6   8
        result.add(8);    //
        result.add(6);
        result.add(3);
        result.show();
        //System.out.println("nya elemen är ");
        //result.remove();
        //result.show();
        for (Integer item : result) {
            System.out.println(" next value " + item);
        }
    }

}

//-----------------------------




class TreeUsingQueue{
    public Node head;
    public Node last;
    private class Node{
        private Integer item;
        private Node next;
        // constructor to be used in insertion method
        public Node(Integer item){
            this.item = item;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insert(Integer item){
        if(head == null){
            last = head = new Node(item);
        }
        else {
            last.next = new Node (item);
            last = last.next;
        }
    }
    public Integer remove(){
        if(isEmpty()) throw new NoSuchElementException(" the queue is empty");
        Integer item = head.item;
        head = head.next;
        return item;

    }
}





