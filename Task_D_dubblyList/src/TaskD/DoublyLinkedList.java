package TaskD;


public class DoublyLinkedList {
    private Link head;
    private int size;


    public class Link {
        private int data;
        public Link previous;
        public Link next;

        //create a constructor
        public Link (int data){
            previous = null;
            this.data = data;
            next = null;
        }

        // den behövs när i DoublyLinkedList classen när vi ska lägga till eller ta bort element
        public Link (Link previous, int data, Link next){
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
        public int Data(){
            return data;
        }
    }


    public DoublyLinkedList(){
        head = null;
        size = 0;
    }

    public void insertAt(int data, int index){
        if (head == null)
            head = new Link(null, data, null);
        else{
            Link current = head;
            while(current.next != null){    // vi gå gram tills head är inte null
                current = current.next;
            }
            Link newLink = new Link(current, data, null);  // här lägger vi nya elementet i slutet av listan
            current.next = newLink;
        }
        if (index < 1 || index > size)
            return;

        Link current = head;
        int i = 1;
        while(i < index){           // här går vi igenom tills vi hittar indexen där vi insertar elementen
            current = current.next;
            i++;
        }
        if(current.previous == null){  // vi är på första indexen/elementen
            Link newLink = new Link(null, data, current);
            current.previous = newLink;
            head = newLink;
        }
        else {
            Link newLink = new Link(current.previous, data, current);  // här skapar vi en ny node
            current.previous.next = newLink;  // elementen innan det element vi insertar pekar på den insertane element
            current.previous = newLink;        // elementen efter den inserterande pekar på den inserterande
        }

        size ++;
    }

    public void removeAt(int index){
        if(head == null)
            if (index < 1 || index > size) return;

        Link current = head;
        int i = 1;
        while(i < index){
            current = current.next;
            i++;
        }
        if(current.next == null){
            current.previous.next = null;
        }
        else if(current.previous == null){
            current = current.next;
            current.previous = null;
            head = current;
        }
        else{
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    public static DoublyLinkedList createlist (int data, int index){
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i =0; i < data; i++){
            list.insertAt(i,index);  // det här är fel
        }
        return list;
    }

    public static void benchMark(int a, int index){
        System.out.println(a);
        int numbers = 1000;
        double sum = 0;
        for(int i = 0; i < numbers; i++){
            DoublyLinkedList list_a = createlist(a, index);
            long t0 = System.nanoTime();
            // list_a.head()
        }
    }

    public int size(){
        return size;
    }
    // to print out the result
    public void print (){
        Link current = head;
        while(current != null){
            System.out.print(current.Data() + " ");
            current = current.next;

        }
        System.out.println();
    }
    public boolean Empty(){
        return head == null; // om head pekar på null då betyder att listan är tomt
    }

    public static void main (String [] args){
        DoublyLinkedList result = new DoublyLinkedList();

        System.out.println("------ check the insert");
        result.insertAt(66, 1);
        result.insertAt(63, 2);
        result.insertAt(70, 3);
        result.insertAt(73, 4);
        result.insertAt(75, 9);
        System.out.println(" size is " + result.size());
        result.print();

        System.out.println("------ check the delete");
        result.removeAt(5);
        //result.removeAt(1);
        result.print();
        //System.out.println(" size is " + result.size());
    }
}









// några metoder som är bra att spara men inte så nödvändig

// metod för att lägga element i början av lista dvs head noden
 /*public void addFront (int data){
    if(head ==null)                           // om head pekar på null, dvs om den är tomt
        head = new Link(null, data, null); // vi lägger till ett element i första noden
    else{
        Link newLink = new Link(null, data, head);
        head.previous = newLink;     // head pekar på ny noden i början av listan
        head = newLink;              // head pekar nu på första noden
    }
    size ++;
}*/
//metod för att ta bort sista elementen
    /*public void removeBack(){
        if(head == null) return;

        if(head.next == null){  //om det finns bara ett element och nästa element pekar på null
            head = null;
            size --;
            return;
        }
        Link current = head;
        while(current.next.next != null){    // så länge noden inte pekar på null
            current = current.next;
        }
        current.next = null;
        size--;
    }*/

// metod för att ta bort första elementen
  /* public void removeFront(){
       if (head == null)
           return;
       head = head.next;
       head.previous = null;
       size--;
   }*/

// add element i slutet av listan
    /*public void addBack(int data){
        if (head == null)
            head = new Link(null, data, null);
        else{
            Link current = head;
            while(current.next != null){    // vi gå gram tills head är inte null
                current = current.next;
            }
            Link newLink = new Link (current, data, null);  // här lägger vi nya elementet i slutet av listan
            current.next = newLink;
        }
        size ++;
    }*/
