package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class CheckForCircularLinkedList {


    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
//        list.addAll(List.of(1,2,3,4,5));
        list.addAll(List.of(3,2,0,-4));
        Node<Integer> temp = list.getHead();
//        System.out.println(checkCircular(temp));
        System.out.println(checkCircular2(temp).value);
    }

    // using two pointer
    public static boolean checkCircular(Node<Integer> head){
        if (head==null)return false;
        Node<Integer> fast = head.next;
        Node<Integer> slow = head;

        // will as every time slow went next fast went two times , so if circular is present then after some time fast will meet slow
        // its like using two loops but using nodes without loop
        while (fast!=slow){
            if(fast==null || fast.next==null)return false;
            fast=fast.next.next;
            slow=slow.next;
        }

        return true;
    }

    // it will return the node from where the circular list starts
    public static Node<Integer> checkCircular2(Node<Integer> head){
        if (head==null)return null;
        Node<Integer> fast = head.next;
        Node<Integer> slow = head;

        // will as every time slow went next fast went two times , so if circular is present then after some time fast will meet slow
        // its like using two loops but using nodes without loop
        while (fast!=slow){
            if(fast==null || fast.next==null)return null;
            fast=fast.next.next;
            slow=slow.next;
        }

        Node<Integer> temp = head;
        while (temp!=slow.next){
            temp=temp.next;
            slow=slow.next;
        }
        return temp;
    }


}
