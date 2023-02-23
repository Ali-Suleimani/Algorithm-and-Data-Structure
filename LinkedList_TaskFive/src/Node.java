public class Node {
    int data;
    Node next;

    public Node(int n) {
        data = n;
        next = null;
    }


    public void append(Node b) {
        Node nxt = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
    }
}
