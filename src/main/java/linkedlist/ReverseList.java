package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class ReverseList {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,3,4,5));
        Node<Integer> temp = list.getHead();
        list.display(temp);
        list.display(temp);
    }

    // create dummy node
    // assign head next to temp node
    // assign head next to dummy so that we can have reverse relation
    // assign head to dummy
    // assign temp node to head so that head can reach to last node
    // time - O(n)
    // space - O(1)
    public static Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer> prev = null;
            while (head != null) {
                Node<Integer> nextNode = head.next;
                head.next = prev; // attach prev to head next element
                prev = head; // make prev head
                head = nextNode; // make nextNode element to head
            }
        return prev;
    }

    // time - O(n)
    // space - O(1)
    public static Node<Integer> reverseListUsingRecursion(Node<Integer> head){
        if(head==null || head.next==null)return head;
        Node<Integer> node = reverseListUsingRecursion(head.next); // when return will give last element and head will be one element back as recursive call come back as one before
        head.next.next=head; // make as head.next is last element and head.next.next is null so making head as last
        head.next = null; // head .next as null;
        return node;
    }


}
