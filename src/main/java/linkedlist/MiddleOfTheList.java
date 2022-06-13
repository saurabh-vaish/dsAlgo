package linkedlist;

import linkedlist.singly.SinglyLinkedListNormal;

import java.util.List;

/**
 * @Link  = https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @Problem  = Given the head of a singly linked list, return the middle node of the linked list.
 *
 *          If there are two middle nodes, return the second middle node.
 *
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class MiddleOfTheList {

    public static void main(String[] args) {
        SinglyLinkedListNormal<Integer> list = new SinglyLinkedListNormal<>();
        list.addAll(List.of(1,2,3,4,5,6));
        Node<Integer> temp = list.getHead();
        list.display(middle(temp));
        list.display(middleIteration(temp));
    }

    // using two pointers as node or tortoise and rabbit method
    // time - O(n/2)
    // spce = O(1) , not using anything extra
    public static Node<Integer> middle(Node<Integer> head){
        if(head==null)return head;
        Node<Integer> fast = head; // use  head.next if want to return first middle if two middle are found
        Node<Integer> slow = head;
        while (fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
        }
        return slow;

    }

    // not recommended
    // normal iteration
    public static Node<Integer> middleIteration(Node<Integer> head){
        if(head==null)return head;
        int count=0;
        Node<Integer> temp = head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        temp = head;
        int mid = (count/2)+1;
        while (mid>1){
            temp=temp.next;
            mid--;
        }

        return temp;

    }
}
