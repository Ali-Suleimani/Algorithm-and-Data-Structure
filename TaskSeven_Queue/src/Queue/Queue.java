package Queue;

public class Queue {
    Node head;
    Node last;
    int size;

    public class Node {
        public Integer item;
        public Node tail;
        public Node next;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }

    }

    public Queue() {
        this.head = null;
        this.last = null;
    }

    public void add(Integer item) {
        Node node = new Node(item, null);
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

}
/*class main{
    public static void main (String [] args) {
        Queue result = new Queue();
        result.add(1);
        result.add(44);
        result.add(789);
        result.show();
        System.out.println("nya elemen är ");
        result.remove();
        result.show();
    }
}*/



