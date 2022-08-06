package linkedlist.singly;

import linkedlist.Node;

import java.util.Collection;
import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class SinglyLinkedListNormal<T> {

    Node<T> head;
    int size;

    public int getSize(){
        return size;
    }

    /**
     * add element at first position
     * @param value
     */
    public void addFirst(T value){
        Node<T> node = new Node<>(value);
        node.next=head;
        head=node;
        size++;
        return;
    }


    public void addLast(T value){
        Node<T> curr = head;
        while (curr.next!=null){
            curr=curr.next;
        }
        Node<T> node = new Node<>(value);
        curr.next=node;
        size++;
        return;
    }

    public void add(T value){
        if(head==null){
            this.addFirst(value);
            return;
        }
        this.addLast(value);
    }

    public void add(T value,int index){
        if(index==0)throw new IndexOutOfBoundsException("Invalid index");
        if(index==1) {
            this.addFirst(value);
            return;
        }
        if(index==size){
            this.addLast(value);
            return;
        }
        Node<T> previousNode = head;
        for (int i = 0; i < index-2; i++) {
            previousNode= previousNode.next;
        }
        Node<T> node = new Node<>(value);
        node.next=previousNode.next;
        previousNode.next=node;
        size++;
    }

    public void addUsingRec(T value,int index){
        head = addRec(value,index,head); // update head
    }

    private Node<T> addRec(T value, int index, Node<T> node) {
        if(index==1){
            Node<T> newNode = new Node<>(value,node);
            node=newNode;
            size++;
            return newNode;
        }
        node.next = addRec(value,index-1,node.next);
        return node;
    }


    public T get(int index){
        if(index>size || index<=0)throw new IndexOutOfBoundsException("No element found ");
        if(head==null)return null;
//        if(head==tail)return head.value;
        Node<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp= temp.next;
        }
        return temp.value;
    }

    public Node<T> getNode(int index){
        if(index>size || index<=0)throw new IndexOutOfBoundsException("Invalid index");
        if(head==null)return null;
//        if(head==tail)return head;
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
        size--;
        return temp.value;
    }


    public T deleteLast(){
        if(head==null) {
            System.out.println("list is empty");
            return null;
        }
        Node<T> secondLast = this.getNode(getSize()-1);
        Node<T> temp = secondLast;
        secondLast.next=null;
        size--;
        return temp.value;
    }

    /**
     * method to delete element in by given index linked list
     * time - O(n)
     */
    public T delete(int index){
        if(index==0)throw new IndexOutOfBoundsException("Invalid index");
        if(index==1)this.deleteFist();
        if(index==size)this.deleteLast();

        Node<T> previous = this.getNode(index-1);
        Node<T> temp = previous;
        previous.next=previous.next.next;
        size--;
        return temp.value;
    }


    /**
     * method to find node by value in linked list
     * time - O(n)
     */
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

    /**
     * method to display linked list
     * time - O(n)
     */
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

    /**
     * method to display linked list from a provided node
     * time - O(n)
     *
     * @param node
     */
    public void display(Node<T> node){
        if(node==null) {
            System.out.println("List is empty !!");
            return;
        }
        Node<T> temp = node;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp=temp.next;
        }
        System.out.println("End");
    }


    public Node<T> getHead() {
        return head;
    }


    public Node<T> peek(){
        return head==null?null:head;
    }

    public void addAll(Collection<T> collection){
        collection.forEach(this::add);
    }

    public static void main(String[] args) {

        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(11);
        list.add(7);

        list.display();

        list.addFirst(1);

        list.addLast(10);

        list.display();

//        System.out.println(list.getSize());

//        list.get(10);
//        System.out.println(list.get(4));

        list.add(55,4);
//        list.add(22,list.getSize());

        list.display();

        System.out.println(list.peek().value);

        list.display();

        list.addUsingRec(44,4);

        list.display();

        System.out.println(list.deleteFist());

        list.display();

        System.out.println(list.deleteLast());

        list.display();

        System.out.println(list.find(44).value);
        System.out.println(list.find(344));

    }

}
