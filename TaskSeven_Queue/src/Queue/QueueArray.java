package Queue;

import java.util.Random;

public class QueueArray {
    private Integer item;
    private Integer capacity = 4;
    private Integer front = -1;
    private Integer tail = -1;
    private Integer[] queue = new Integer[capacity];

    public void enqueue(Integer item) {
        if (tail == capacity - 1) { // if the queue is full
            resize();
            tail++;
        }
        //System.out.println("The queue is full");

        else if (front == -1 && tail == -1) {  // check the condition if front and tail are outside of the queue
            front = tail = 0;                 // increment them by zero, both points to zero index and still empty
            queue[tail] = item;               // inser an element in the queue
        } else {
            tail++;
            queue[tail] = item;
        }
    }

    public void dequeue() {
        if (front == -1 && tail == -1) {
            System.out.println("the queue is empty");
        } else if (front == tail) {
            front = tail = -1;
        } else {
            front++;
        }
    }


    public void resize() {
        Integer[] newSizeQueue = queue;
        capacity = capacity * 2;
        queue = new Integer[capacity];
        for (int i = 0; i <= tail; i++) {
            queue[i] = newSizeQueue[i];
        }
    }


    public void display() {
        int i;
        if (front == -1 && tail == -1) {
            System.out.println(" the queue is empty");
        } else {
            for (i = front; i <= tail; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}


class main {
    public static void main(String[] args) {

        QueueArray result = new QueueArray();

        Random rnd = new Random();
        int[] elements = new int[3];
        for (int i = 1; i < elements.length; i++) {
            elements[i] = rnd.nextInt(10);
        }
            long t0 = System.nanoTime();
            result.enqueue(elements);
            result.display();
        long t1 = System.nanoTime();
        System.out.println("Exekveringstiden är" + (t1 - t0));

    }
}
       // result.enqueue(elements);

       // result.display();
      //  result.enqueue(elements[i]);




       /* QueueArray result = new QueueArray();
        result.enqueue(45);
        result.enqueue(67);
        result.enqueue(678);
        result.enqueue(6076);
        result.enqueue(65);
        result.enqueue(656);
        result.enqueue(658);
        result.display();
        System.out.println(" the dequeue element is");
        result.dequeue();
        result.display();*/
    //}
//}*/


