//import java.security.spec.RSAOtherPrimeInfo;

public class DynamicStack {
        int top = -1;
        int stacSize = 1; // empty stack
        int[] object = new int[stacSize];


        public int stackEmpty() {
            if (top == -1) {
                System.out.println("stack is empty");
            }
            return 0;

        }
        public int stackFull(){
            if(top == stacSize -1){
                System.out.println(" stack in sull");
            }
            return 0;
        }
        public int pop(){
            return object[top];
        }
        public void push( int data){
            if(top >= stacSize-1)
                resize();
            object[++top]= data; //increase the value of the top element and then assign the value of data

        }
        private void resize(){
            int [] newArry = object;
            stacSize = stacSize*2;
            object = new int [stacSize];
            for (int i = 0; i <= top; i++){
                object[i] = newArry[i];
            }
        }


    public static void main(String[] args){
        DynamicStack str = new DynamicStack();
        str.push(34);
        str.push(34);
        str.push(3);
        str.push(4);
        System.out.println(str.stacSize);
    }
}
