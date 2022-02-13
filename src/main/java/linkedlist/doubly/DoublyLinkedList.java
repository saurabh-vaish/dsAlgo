package linkedlist.doubly;


/***
 *  Implemention of doubly linked list without two pointers. as using two pointers we already created singly linked list.
 */
public class DoublyLinkedList<T> {

    private static class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value){
            this.value = value;
        }

        public Node(T value, Node<T> next,Node<T> prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private int size;

    public DoublyLinkedList(){
        int size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * add element at first position
     * @param value
     */
    public void addFirst(T value){
        Node<T> node = new Node<>(value,head,null);
        if(head!=null){
            head.prev=node; // attach previous node to new node
        }
        head=node;
        size++;
    }



    public void add(T value){
        if(head==null){
            this.addFirst(value);
        }
        Node<T> temp =head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next= new Node<T>(value,null,temp);
        size++;
    }

    public void add(T value,int index){
        if(index==0)throw new IndexOutOfBoundsException("Invalid index");
        if(index==1) {
            this.addFirst(value);
            return;
        }
        if(index==size){
            this.add(value);
            return;
        }
        Node<T> previousNode = head;
        for (int i = 1; i < index-1; i++) {
            previousNode= previousNode.next;
        }
        Node<T> node = new Node<>(value,previousNode.next,previousNode);
        if(previousNode.next!=null) {
            previousNode.next.prev = node;
        }
        previousNode.next=node;
        size++;
    }

//    public void addUsingRec(T value,int index){
//        addRec(value,index,head);
//    }
//
//    private Node<T> addRec(T value, int index, Node<T> node) {
//        if(index==1){
//            Node<T> newNode = new Node<>(value, node);
//            node=newNode;
//            size++;
//            return newNode;
//        }
//        node.next = addRec(value,index-1,node.next);
//        return node;
//    }


    public T get(int index){
        if(index>size || index<=0)throw new IndexOutOfBoundsException("No element found ");
        if(head==null)return null;
        Node<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp= temp.next;
        }
        return temp.value;
    }

    private Node<T> getNode(int index){
        if(index>size || index<=0)throw new IndexOutOfBoundsException("Invalid index");
        if(head==null)return null;
        Node<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp= temp.next;
        }
        return temp;
    }


    public T deleteFist(){
        if(head==null) {
            System.out.println("list is empty");
            return null;
        }
        Node<T> temp = head;
        head=head.next;
        head.prev=null;
        size--;
        return temp.value;
    }


    public T deleteLast(){
        if(head==null) {
            System.out.println("list is empty");
            return null;
        }
        Node<T> temp = this.getNode(getSize());
        Node<T> prev = temp.prev;
        if(prev!=null){
            prev.next=null;
        }
        size--;
        return temp.value;
    }

    public T delete(int index){
        if(index==0)throw new IndexOutOfBoundsException("Invalid index");
        if(index==1)this.deleteFist();
        if(index==size)this.deleteLast();

        Node<T> temp = this.getNode(index);
        if(temp.prev!=null){
            temp.prev.next=temp.next;
        }
        if(temp.next!=null) {
            temp.next.prev = temp.prev;
        }
        size--;
        return temp.value;
    }


    public Node<T> find(T value){
        if(head==null){
            System.out.println("List is empty !!");
            return null;
        }
        Node<T> temp = head;
        while (temp!=null){
            if(temp.value==value)return temp;
            temp=temp.next;
        }
        return null;
    }

    public void display(){
        if(head==null) {
            System.out.println("List is empty !!");
            return;
        }
        Node<T> temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp=temp.next;
        }
        System.out.println("End");
    }


    public Node<T> peek(){
        return head==null?null:head;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(11);
        list.add(7);

        list.display();

        list.addFirst(1);

        list.display();

//        System.out.println(list.getSize());

//        list.get(10);
        System.out.println(list.get(4));

        list.add(55,4);
//        list.add(22,list.getSize());

        list.display();

        System.out.println(list.peek().value);

        list.display();

        System.out.println(list.deleteFist());

        list.display();

        System.out.println(list.deleteLast());

        list.display();

        System.out.println(list.find(55).value);
        System.out.println(list.find(344));

    }
}
