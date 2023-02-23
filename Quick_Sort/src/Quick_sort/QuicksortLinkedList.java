package Quick_sort;

public class QuicksortLinkedList {
    public static class Node{
        int list;
        Node next;

        Node (int d){
            this.list = d;
            this.next = null;
        }

    }

    Node head;
    void addingNode (int list){
        if(head == null){
            head = new Node(list);
            return;
        }
        Node current = head;
        while(current.next != null)
            current = current.next;

        Node newNode = new Node(list);
        current = current.next;
    }

    void printList(Node n){
        while (n != null){
            System.out.println(n.list);
            System.out.println(" ");
            n= n.next;
        }
    }

    Node partitionList(Node start, Node end){
        if (start == end || start == null || end == null)
            return start;
        Node pivot_prev = start;
        Node current = start;
        int pivot = end.list;

        while(start != end){
            if(start.list < pivot){

                pivot_prev = current;
                int temp = current.list;
                current.list = start.list;
                start.list = temp;
                current = current.next;

            }
            start = start.next;
        }
        int temporer= current.list;
        current.list = pivot;
        end.list = temporer;

        return pivot_prev;
    }

    void sort(Node start, Node end){
        if(start == null || start == end || start == end.next)
            return;

        Node pivot_prev = partitionList(start, end);
        sort(start, pivot_prev);

       if(pivot_prev !=null && pivot_prev == start)
           sort(pivot_prev.next, end);

       else if(pivot_prev != null && pivot_prev.next != null)
           sort(pivot_prev.next.next, end);

    }
    public static void main(String [] args){
        QuicksortLinkedList result = new QuicksortLinkedList();
        result.addingNode(56);
        result.addingNode(5);
        result.addingNode(10);
        result.addingNode(59);

        Node n = result.head;
        while(n.next != null)
            n = n.next;
        System.out.println(" before sorting");
        result.printList(result.head);

        result.sort(result.head, n);

        System.out.println("after sorting");
        result.printList(result.head);

    }
}
