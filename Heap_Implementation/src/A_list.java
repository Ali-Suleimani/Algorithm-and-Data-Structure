/*public class A_list {

        public Node first;

        class Node {
            public Integer item;
            public Node next;

            public Integer priority;

            public Node(Integer prio, Integer item, Node nod) {
                this.priority =prio;
                this.item= item;
                this.next=null;
            }
        }

        public A_list(){
            this.first = null;
        }

        public void print() {
            if (this.first == null) {
                System.out.println("print(): queue is empty");
                return;
            }
            Node current = this.first;
            System.out.println("start of queue");
            while (current != null) {
                System.out.println(current.priority);
                current = current.next;
            }
        }
        public void enquene(Integer prio, Integer item) {
            Node begin = null;
            Node temp = first;
            while(temp != null && prio.compareTo(temp.priority)>0) {
                begin = temp;
                temp = temp.next;
            }
            if(begin == null)
                first = new Node (prio, item, first);
            else
                begin.next = new Node(prio, item, temp);
             System.out.println(" the priority: " + prio + " the item: "+item);
        }


        Integer peek(){
            if(isEmpty())
                System.out.println("No peek element");
            System.exit(-1);
            return first.item;
        }
        public boolean isEmpty(){
            return (first == null);
        }


        public Integer dequeue() {

            if(isEmpty()) {
                System.out.println("Nothing to delete ");
                System.exit(-1);
            }
            Node temp = first;
            System.out.println( temp.priority);

            first= first.next;


            return temp.priority;
        }

        public static void main(String [] args){
            A_list result = new A_list();
            result.enquene(36, 37);
            result.enquene(5, 3);
            result.enquene(7, 370);
            result.enquene(6, 9);
            result.print();
        }

    }*/
