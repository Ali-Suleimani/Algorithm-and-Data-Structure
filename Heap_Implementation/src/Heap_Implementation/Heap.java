package Heap_Implementation;

public class Heap {
    Node root;
    public class Node{
        Integer priority;
        Node leftChild;
        Node rightChild;
        Integer size;

        public  Node(Integer item){
            this.priority = item;
            this.leftChild = null;
            this.rightChild = null;
            Integer size;
        }

        private Integer add(Integer item){
            Node node = new Node(item);
            if(root ==null){
                root = node;
            }
             if(item < this.priority){
                 Integer temp = this.priority;
                 this.priority = item;
                 item = temp;
             }
             this.size +=1;
             if(this.leftChild == null){
                 this.leftChild = new Node(item);
                 return 1;
             }
             else if(this.rightChild == null){
                 this.rightChild = new Node(item);
             }
             else if(this.rightChild.size < this.leftChild.size){
                 return this.rightChild.add(item) +1;
             }
             else{
                 return this.leftChild.add(item) +1;
             }
             size++;
             return item;
        }

        public void enqueue(Integer item){
            if(root != null)
                root.add(item); // lägga till element
            else
                root = new Node(item);
            return;
        }

        private void display(Integer n){
            System.out.println(" ".repeat(n) + this.priority + "(" + this.size + ")");

            if(this.leftChild != null  && this.rightChild == null)
                return;
               if(this.leftChild != null)
                   this.leftChild.display(n+2);
               else
                   System.out.println(" ".repeat(n+2) + "---");
               if(this.rightChild != null)
                   this.rightChild.display(n+2);
               else
                   System.out.println(" ".repeat(n+2) + "...");
        }

    }
    public static void main (String [] args){
        Heap queue = new Heap();
        queue.enqueue(89);
        queue.display();
    }

}
