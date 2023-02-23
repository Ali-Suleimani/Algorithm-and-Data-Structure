import java.util.Stack;
import java.io.*;
public class StaticStack {
    int top = -1;
    int capacity = 4;
    int [] stack = new int[4];

     public boolean stackEmpty(){
        return top ==-1;
     }

     public boolean stackFull(){
        return top == capacity -1; // -1 because the stack starts from 0
     }

     public int push(int data){
        if (stackFull()){
            System.out.println("Stack is full");
        }
        return stack[++top] = data;

     }
     public int pop(int data){
        if(stackEmpty()){
            System.out.println("stack is empty");
        }
        return stack[--top]= data;
     }
     public void display(){
        for (int i:stack){
            System.out.println(i);
        }

     }
    public static void main(String []args) {
        StaticStack str = new StaticStack();
        str.push(9);
        str.push(9);
        str.push(10);
        System.out.println(str.capacity);
        str.display();

        }
    }

