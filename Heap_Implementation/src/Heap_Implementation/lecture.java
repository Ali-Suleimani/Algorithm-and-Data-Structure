package Heap_Implementation;

/*public class Heap {

        Node root;
        private Node{
            Integer priority;
            Node left;
            Node right;

            private class Node(Integer prio){
            this.priority = prio;
            this.left = null;
            this.right = null;
            Integer size;
            }

            private Integer add(Integer prio){
                if(prio < this.priority){
                    Integer temp= this.priority;
                    this.priority = prio;
                    prio = temp;
                }
                this.size +=1;
                if(this.left == null){
                    this.left = new Node(prio);
                    return 1;
                }
                else if(this.right == null){
                    this.right = new Node(prio);
                }
                else if(this.right .size < this.left.size){ // balanserra
                    return this.right.add(prio) +1;
                }
                else{
                    treturn his.right.add(prio) +1;
                }

            }

            private Node remove(){
                if(this.left == null && this.right == null){
                    return null;
                }
                else if(this.left == null) {
                    return this.right;
                }
                else if(this.right == null){
                    return this.left;
                }
                else if ( this.left.priority < this.right.priority){
                   this.size = -1;  // balansera
                    this.priority = this.left.priority;
                    this.left = this.left.remove();

                }
                else{

                    this.priority = this.right.priority;
                    this.right = this.right.remove();
                }
                   this.size = -1;
                    return this;

            }

            private Boolean check(){
                Integer prio = this.priority;
                Boolean lc = true;
                if(this.left !=null){
                    if(this.left.priority >= prio){
                        lc= this.left.check(),
                    }
                    else
                        System.out.println(" left branch higher priority" );
                    lc= false;
                }
                  // change to right
                if(this.left !=null){
                    if(this.left.priority >= prio){
                        lc= this.left.check(),
                    }
                    else
                        System.out.println(" left branch higher priority" );
                    lc= false;
            }


            private void print(Integer n){
                System.out.println(" ".repeat(n) + this.priority);
                if (this.left != null)
                    this.left.println(n+2);
                else()
            }
        }

        public void enqueue(Integer prio){
            if(root != null)
                root.add(prio); // lägga ett nude
            else
                root= new Node(prio);
        }

            public void dequeue(Integer prio){
                if(root != null)
                    Integer ret= root.priority;
                    return root.remove(); // lägga ett nude
                else
                    root= new Node(prio);
                return 0;
            }



            // print metod


        public static void main(String [] arg){
            Heap_Implementation.Heap queue = new Heap_Implementation.Heap();
            queue .enqueue(12);
                queue .enqueue(12);
                queue .enqueue(12);
                queue .enqueue(12);
                queue.print();
                queue.dequeue();
                Integer d = queue.enqueue(6);
                System.out.println(" depth " + );
        }
    }*/


