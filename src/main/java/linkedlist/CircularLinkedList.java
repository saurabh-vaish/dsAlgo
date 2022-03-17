package linkedlist;

/***
 * Implement a circular linked list
 *
 */
public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next= newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void insertAt(int index,T data){
        Node<T> node = new Node<>(data);
        if(head==null && index==1){
            head=node;
            tail=node;
            tail.next=head;
        }else if(index>size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }else {
            Node<T> temp = head;
            for (int i = 1; i < index-1; i++) {
                temp = temp.next;
            }
            node.next=temp.next;
            temp.next=node;
        }
    }

    public void delete(T data){
        if (head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.value==data){
            head=head.next;
            tail.next=head;
            size--;
            return;
        }
        if(head==tail){
            head=tail=null;
            size--;
            return;
        }

        Node<T> temp = head;
        while (temp.next!=head){
            if(temp.next.value==data){
                temp.next=temp.next.next;
                size--;
                break;
            }
            temp=temp.next;
        }
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head==tail){
            System.out.println(head.value+"--> head");
            return;
        }
        Node<T> temp = head;
        do {
            System.out.print(temp.value+"-->");
            temp = temp.next;
        } while(temp!=head);
        System.out.println("head");
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.insertAt(3,44);

        list.display();

        list.delete(4);

        list.display();
    }
}
