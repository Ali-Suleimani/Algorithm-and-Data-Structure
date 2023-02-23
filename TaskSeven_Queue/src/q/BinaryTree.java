package q;

import java.util.*;

public class BinaryTree implements Iterable<Integer> {
    public static Node root;

    public class Node {
        public Integer key;
        public Integer val;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.val = value;
            this.left = this.right = null;
        }

        public Queue keys() {
            Queue queue = new Queue();
          ///  stack.push(root.key);
             breadthFirst(queue);
            return queue;
        }

        public void breadthFirst(Queue queue) {
            if (root == this) {
                queue.insert(root.key);
            }
            if (left != null) {
                queue.insert(left.key);
            }

            if (right != null) {
                queue.insert(right.key);
            }

            if (left != null) {
                left.breadthFirst(queue);
            }

            if (right != null) {
                right.breadthFirst(queue);
            }
        }
    }


    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            return;
        }
        root = add(root, key, val);

    }

    private Node add(Node x, Integer key, Integer val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key, val);
        else if (cmp > 0) x.right = add(x.right, key, val);
        else x.val = val;
        return x;
    }
    //----------------------------
    public Integer lookup(Integer key) {
        return lookup(root, key);
    }

    private Integer lookup(Node x, Integer key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return lookup(x.left, key);
        else if (cmp > 0) return lookup(x.right, key);
        else return x.val;
    }
    //_______________________________
    public Iterator<Integer> iterator() {
        return new LinkedIterator();
    }

    public Queue getStack() {
        return root.keys();
    }
//-------------------------------------

    private class LinkedIterator implements Iterator<Integer> {
        private Node current;
        private Queue queue;

        public LinkedIterator() {
            queue = getStack();
        }
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            Integer key = queue.remove();
            return key;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    public static void main(String[] args) {
        BinaryTree st1 = new BinaryTree();
        int n = 000;
        Random rnd = new Random(60);
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = rnd.nextInt(n + 40);
            sequence[i] = key;
            st1.add(key, i);
            // System.out.println(key + "  " + i);
        }

        BinaryTree tree = new BinaryTree();
        tree.add(5, 105);                       //     5
        tree.add(2, 102);                     //  2        7
        tree.add(7, 107);                    // 1    3    6   8
        tree.add(1, 101);
        tree.add(8, 108);
        tree.add(6, 106);
        tree.add(3, 103);
        long t0 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            Integer key = rnd.nextInt(n + 40);
            tree.add(key, key+100);
        }


        for (Integer item : tree) {
            System.out.println(" next value " + item);
        }
        long t1 = System.nanoTime();
        System.out.println(" run time is " + ((t1-t0)/1000000) + " millisecond");

    }
}

class Queue {
    public Node head;
    public  Node last;
    private class Node{
        private Integer item;
        private  Node next;
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
            last.next = new Node(item);
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




