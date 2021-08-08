package queue;

/**
 * @Problem :- Implement Queue having complexity O(1)
 *
 * @Solution  === Its solution is based on linked list and it follows LIFO concept
 *
 * @Complexity  == O(1) for enqueue and dequeue , for print O(n)  [ both space and time ]
 *
 * @author Saurabh Vaish
 * @Date 23-07-2021
 */


class QueueNode<T>{
    public T value;
    public QueueNode<T> next;

    public QueueNode(T value){
        this.value=value;
        this.next=null;
    }

}


public class Queue<T> {

    public QueueNode<T> front;
    public QueueNode<T> back;
    public int size;


    public void enqueue(T value){
        QueueNode<T> node = new QueueNode<>(value);
        if(this.size==0){
            this.front=node;
            this.back=node;
            this.size++;
            return;
        }
        this.back.next=node;
        this.back=node;
        this.size++;
    }

    public T dequeue(){
        if(this.front==null || this.size==0){
            System.out.println("Queue is empty");
            return null;
        }
        QueueNode<T> node = this.front;
        this.front=node.next;
        this.size--;
        return node.value;
    }

    public void print(){
        if(this.size==0 || this.front==null) System.out.println("Queue is Empty");
        QueueNode<T> node=this.front;
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.print();
        System.out.println("size ="+queue.size);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        System.out.println("size ="+queue.size);
        queue.print();

    }

}
